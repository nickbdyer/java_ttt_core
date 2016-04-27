package com.company;

import java.util.*;
import java.util.Map.Entry;

import static com.company.Mark.*;

public class PerfectComputer implements Player{

    private Mark mark;
    private Map<Integer, Double> scoredMoves;
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
        if (board.isEmpty()) return chooseRandomCorner();
        resetMoveCalculations();
        makeMoveCalculations(board);
        return bestMove.getKey();
    }

    private void makeMoveCalculations(Board board) {
        negamax(board, 0, -10, 10, 1);
        findBestMove();
    }

    private void resetMoveCalculations() {
        scoredMoves = new HashMap<>();
        bestMove = null;
    }

    private int chooseRandomCorner() {
        List<Integer> corners = Arrays.asList(0, 2, 6, 8);
        Collections.shuffle(corners);
        return corners.get(0);
    }

    private double negamax(Board board, int depth, double α, double β, int color) {
        if (board.isFull() || board.hasWinner()) return color * score(board, depth);
        double bestValue = -10;
        for (int cell : board.availableMoves()) {
            markCell(board, color, cell);
            double val = -negamax(board, depth + 1, -β, -α, -color);
            board.mark(cell, EMPTY);
            bestValue = Collections.max(Arrays.asList(bestValue, val));
            if (depth == 0) scoredMoves.put(cell, bestValue);
            α = Collections.max(Arrays.asList(α, bestValue));
            if (α >= β) break;
        }
        return bestValue;
    }

    private void markCell(Board board, int color, int cell) {
        if (color == 1) {
            board.mark(cell, getMark());
        } else {
            board.mark(cell, opponent_symbol());
        }
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

    private void findBestMove() {
        for (Entry<Integer,Double> entry : scoredMoves.entrySet()) {
            if (bestMove == null || entry.getValue().compareTo(bestMove.getValue()) > 0) {
                bestMove = entry;
            }
        }
    }
}
