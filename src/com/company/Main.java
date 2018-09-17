package com.company;

import java.util.ArrayList;

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
            depth(startState);
        }
    }

    static void width(State startState)
    {
        State current;
        ArrayList hashCheck = new ArrayList();
        ArrayList<State> States = new ArrayList<>();
        States.add(startState);
        while(States.size()>0) {
            if(States.get(0).isFinish()) {
                current = States.get(0);
                while (current!=null)
                {
                    System.out.println(current.hash);
                    current=current.parent;
                }
                System.out.print("\n\n");
            }
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
        State current;
        ArrayList hashCheck = new ArrayList();
        ArrayList<State> States = new ArrayList<>();
        States.add(startState);
        while(States.size()>0) {
            if(States.get(0).isFinish()) {
                current = States.get(0);
                while (current!=null)
                {
                    System.out.println(current.hash);
                    current=current.parent;
                }
                System.out.print("\n\n");
            }
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
