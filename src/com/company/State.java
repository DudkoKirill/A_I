package com.company;

import java.util.ArrayList;
import java.util.List;

public class State {
    State parent;
    int empty;
    int hash;
    int deep;
    static int count=0;
    ArrayList<State> childs;
    int fields[];

    State(int[] x , State Par, int empt) {
        fields= new int[9];
        childs = new ArrayList<State>();
        hash=0;
        int j=100000000;
        for (int i=0;i<9;i++) {
            fields[i]=x[i];
            hash+=x[i]*j;
            j/=10;
        }
        parent = Par;
        empty = empt;
        count ++;
        if (parent==null)
            deep=0;
        else
            deep=parent.deep+1;
    }

    void setChilds()
    {
        ArrayList<Integer> childFields = new ArrayList();
        if (empty%3 >=1)
            childFields.add(empty-1);
        if (empty%3 <=1)
            childFields.add(empty+1);
        if (empty-3 >=0)
            childFields.add(empty-3);
        if (empty+3 <=8)
            childFields.add(empty+3);
        int copyFields[];
        int copy;
        for (int i =0; i<childFields.size();i++) {
            copyFields = fields.clone();
            copy = copyFields[empty];
            copyFields[empty] = copyFields [(int)childFields.get(i)];
            copyFields[(int)childFields.get(i)] = copy;
            childs.add(new State(copyFields,this,(int)childFields.get(i)));
        }
    }

    Boolean isFinish()
    {
        return hash==12345678;
    }
}
