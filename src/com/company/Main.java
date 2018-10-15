package com.company;


import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] start = {7, 2, 4, 5, 0, 6, 8, 3, 1};
        int check[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int empty = 0;
        boolean fail = false;
        if (start.length != 9) {
            System.out.print("Count of numbers must be 9");
            fail = true;
        } else {
            for (int i = 0; i < 9 && !fail; i++) {
                if (start[i] == 0)
                    empty = i;
                check[start[i]]--;
                if (check[start[i]] < 0)
                    fail = true;
            }
        }
        if (!fail) {
            //depth();
            width();
        }
    }


    static void width() {
        int[] start1 = {5, 8, 3, 4, 0, 2, 7, 6, 1};
        State startState = new State(start1, null, 4);
        System.out.println("Поиск в ширину");
        Set<Integer> hashCheck = new HashSet<>();
        List<State> states = new LinkedList<>();
        states.add(startState);
        Date start = new Date();
        while (states.size() > 0) {
            State state = states.get(0);
            if (state.isFinish())
                System.out.println("Решение найдено! Глубина: " + state.deep + " Время решения: " + ((new Date()).getTime() - start.getTime() + " мс"));
            else if (!hashCheck.contains(state.hash)) {
                hashCheck.add(state.hash);
                state.setChilds();
                states.addAll(state.childes);
            }
            states.remove(0);
        }
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void depth() {
        int[] start1 = {5, 8, 3, 4, 0, 2, 7, 6, 1};
        State startState = new State(start1, null, 4);
        System.out.println("Поиск в глубину");
        Set<Integer> hashCheck = new HashSet<>();
        List<State> states = new LinkedList<>();
        states.add(startState);
        Date start = new Date();
        while (states.size() > 0) {
            State state = states.get(0);
            if (state.isFinish())
                System.out.println("Решение найдено! Глубина: " + state.deep + " Время решения: " + ((new Date()).getTime() - start.getTime() + " мс"));
            else if (!hashCheck.contains(state.hash)) {
                hashCheck.add(state.hash);
                state.setChilds();
                states.addAll(1, state.childes);
            }
            states.remove(0);
        }
    }
}
