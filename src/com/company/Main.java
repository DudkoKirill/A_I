package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] st = {7,2,4,5,0,6,8,3,1};
        State current;
        State startState=new State(st,null,4);
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
}
