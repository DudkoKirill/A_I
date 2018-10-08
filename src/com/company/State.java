package com.company;

import java.util.ArrayList;
import java.util.List;

class State {
    private int empty;
    int hash;
    int deep;
    int func;
    List<State> childes;
    private int fields[];

    State(int[] x, State par, int empt) {
        fields = new int[9];
        hash = 0;
        int j = 100000000;
        for (int i = 0; i < 9; i++, j/=10) {
            fields[i] = x[i];
            hash += x[i] * j;
        }
        empty = empt;
        if (par == null)
            deep = 0;
        else
            deep = par.deep + 1;
        func=getH1();
    }

    void setChilds() {
        childes = new ArrayList<>();
        List<Integer> childFields = new ArrayList();
        if (empty % 3 >= 1)
            childFields.add(empty - 1);
        if (empty % 3 <= 1)
            childFields.add(empty + 1);
        if (empty - 3 >= 0)
            childFields.add(empty - 3);
        if (empty + 3 <= 8)
            childFields.add(empty + 3);
        int copyFields[];
        int copy;
        for (int i = 0; i < childFields.size(); i++) {
            copyFields = fields.clone();
            copy = copyFields[empty];
            copyFields[empty] = copyFields[childFields.get(i)];
            copyFields[childFields.get(i)] = copy;
            childes.add(new State(copyFields, this, childFields.get(i)));
        }
    }

    Boolean isFinish() {
        return hash == 123456780;
    }

    int getH1(){
        int result=0;
        for(int i=0;i<8;i++){
            if(i+1!=fields[i])
                result++;
        }
        if(fields[8]!=0) result++;
            return result;
    }

    int getH2(){
        return 0;
    }
}
