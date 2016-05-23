package uk.nickbdyer.tictactoe.players;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Mark;
import uk.nickbdyer.tictactoe.Player;
import uk.nickbdyer.tictactoe.UserInterface;
import uk.nickbdyer.tictactoe.exceptions.BoardUnplayableException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static uk.nickbdyer.tictactoe.Mark.*;

public class PerfectComputer implements Player {

    private Mark mark;

    public PerfectComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public int choosePosition(Board board, UserInterface ui) {
        if (board.isUnplayable()) throw new BoardUnplayableException();
        if (board.isEmpty()) return chooseRandomCorner();
        return (int) negamax(board, 0, -10, 10, 1);
    }

    private int chooseRandomCorner() {
        List<Integer> corners = Arrays.asList(0, 2, 6, 8);
        Collections.shuffle(corners);
        return corners.get(0);
    }

    private double negamax(Board board, int depth, double α, double β, int color) {
        if (board.isUnplayable()) return color * score(board, depth);
        double bestValue = -10;
        double bestMove = 0;
        for (int cell : board.availableMoves()) {
            markCell(board, color, cell);
            double val = -negamax(board, depth + 1, -β, -α, -color);
            board.mark(cell, EMPTY);
            bestValue = Math.max(bestValue, val);
            if (depth == 0 && bestValue > α) bestMove = cell;
            α = Math.max(α, bestValue);
            if (α >= β) break;
        }
        if (depth == 0) return bestMove;
        return bestValue;
    }

    private void markCell(Board board, int color, int cell) {
        if (color == 1) {
            board.mark(cell, getMark());
        } else {
            board.mark(cell, opponentSymbol());
        }
    }

    private Mark opponentSymbol() {
        return getMark() == X ? O : X;
    }

    private double score(Board board, int depth) {
        if (board.getWinningMark() == getMark()) return (10.0 / depth);
        if (board.getWinningMark() == opponentSymbol()) return (-10.0 / depth);
        if (board.isFull()) return 0;
        throw new BoardUnplayableException();
    }
}
