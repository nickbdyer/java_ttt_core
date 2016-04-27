package com.company;

import java.util.*;
import java.util.Map.Entry;

import static com.company.Mark.*;

public class PerfectComputer implements Player{

    private Mark mark;
    private Map<Integer, Double> scored_moves;
    private Map.Entry<Integer, Double> bestMove;

    public PerfectComputer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public int choosePosition(UserInterface userInterface, Board board) {
        if (board.isEmpty()) {
            List<Integer> corners = Arrays.asList(0, 2, 6, 8);
            Collections.shuffle(corners);
            return corners.get(0);
        }
        scored_moves = new HashMap<Integer, Double>();
        bestMove = null;
        negamax(board, 0, -10, 10, 1);
        findBestMove();
        return bestMove.getKey();
    }

    private void findBestMove() {
         for (Entry<Integer,Double> entry : scored_moves.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
    }

    private double negamax(Board board, int depth, double α, double β, int color) {
        if (board.isFull() || board.hasWinner()) return color * score(board, depth);
        double bestValue = -10;
        for (int cell : board.availableMoves()) {
            if (color == 1) {
                board.mark(cell, getMark());
            } else {
                board.mark(cell, opponent_symbol());
            }
            double val = -negamax(board, depth + 1, -β, -α, -color);
            board.mark(cell, EMPTY);
            bestValue = Collections.max(Arrays.asList(bestValue, val));
            if (depth == 0) scored_moves.put(cell, bestValue);
            α = Collections.max(Arrays.asList(α, bestValue));
            if (α >= β) break;
        }
        return bestValue;
    }

    private Mark opponent_symbol() {
        return getMark() == X ? O : X;
    }

    private double score(Board board, int depth) {
        if (board.getWinningMark() == getMark()) return (10.0 / depth);
        if (board.getWinningMark() == opponent_symbol()) return (-10.0 / depth);
        if (board.isFull()) return 0;
        return 0;
    }
}
