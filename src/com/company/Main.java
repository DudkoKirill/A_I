package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        int[] start = {7,2,4,5,0,6,8,3,1};
        int check[]={1,1,1,1,1,1,1,1,1};
        int empty=0;
        boolean fail=false;
        if (start.length!=9) {
            System.out.print("Count of numbers must be 9");
            fail = true;
        }
        else {
            for (int i=0;i<9 && !fail;i++)
            {
                if (start[i]==0)
                    empty=i;
                check[start[i]]--;
                if (check[start[i]]<0)
                    fail=true;
            }
        }
        if (!fail) {
            State startState = new State(start, null, empty);
            width(startState);
            depth(startState);
        }
    }

    static void width(State startState)
    {

        System.out.println("Поиск в ширину");
        Date start = new Date();
        ArrayList hashCheck = new ArrayList();
        ArrayList<State> States = new ArrayList<>();
        States.add(startState);
        while(States.size()>0) {
            if(States.get(0).isFinish())
                System.out.println("Решение найдено! Глубина: "+States.get(0).deep + " Время решения:" + ((new Date()).getTime() - start.getTime() + " мс"));
            else if (hashCheck.indexOf(States.get(0).hash) == -1) {
                hashCheck.add(States.get(0).hash);
                States.get(0).setChilds();
                for (int i = 0; i<States.get(0).childes.size(); i++)
                    States.add(States.get(0).childes.get(i));
            }
            States.remove(0);
        }
    }

    static void depth(State startState)
    {
        System.out.println("Поиск в глубину");
        Date start = new Date();
        ArrayList hashCheck = new ArrayList();
        ArrayList<State> States = new ArrayList<>();
        States.add(startState);
        while(States.size()>0) {
            if(States.get(0).isFinish())
                System.out.println("Решение найдено! Глубина: "+States.get(0).deep + " Время решения:" + ((new Date()).getTime() - start.getTime() + " мс"));
            else if (hashCheck.indexOf(States.get(0).hash) == -1) {
                hashCheck.add(States.get(0).hash);
                States.get(0).setChilds();
                for (int i = 0; i<States.get(0).childes.size(); i++)
                    States.add(1,States.get(0).childes.get(i));
            }
            States.remove(0);
        }
    }
}
