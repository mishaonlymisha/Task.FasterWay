package com.company;


import java.util.LinkedList;
import java.util.Queue;

public class Field {
    private char [][] field;
    private int [][]graph;
    private int start_vert,finish_vert,start_port,finish_port,size;


    public Field(char []matrix) {
        int size_matrix=(int)Math.sqrt(matrix.length);
        field=new char[size_matrix][size_matrix];
        int elem=0;
        for(int i=0;i<size_matrix;i++){
            for(int j=0;j<size_matrix;j++){
                field[i][j]=matrix[elem];
                elem++;
            }
        }

        int [][]field2=new int[field.length][field[0].length];
        int flag =0;
        int count_vertex=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (field[i][j] == 'S') {
                    start_vert=count_vertex;

                }
                if (field[i][j] == 'F') {

                    finish_vert=count_vertex;

                }
                if(field[i][j]=='P' && flag==0){

                    flag =1;
                    start_port=count_vertex;

                }
                if(field[i][j]=='P' && flag==1){
                    finish_port=count_vertex;


                }
                if(field[i][j]=='^') {
                    field2[i][j]=-1;
                    count_vertex--;
                }
                else
                    field2[i][j]=count_vertex;
                count_vertex++;

            }
        }
//
//
//
        size=count_vertex;
        graph=new int[count_vertex][4];
//
//

//
//      Graph initialization
//
        int count=0;
        for(int i=0;i<field2.length;i++){
            for(int j=0;j<field2[i].length;j++){
                if(field2[i][j]!=-1){
                    if((i-1)>=0 ) {
                        if(field2[i-1][j]!=-1) {
                            graph[field2[i][j]][count] = field2[i -1][j];
                            count++;
                        }
                    }

                    if((j-1)>=0)  {
                        if(field2[i][j-1]!=-1) {
                            graph[field2[i][j]][count] = field2[i][j - 1];
                            count++;
                        }
                    }

                    if((j+1)<=3){
                        if(field2[i][j+1]!=-1) {
                            graph[field2[i][j]][count] = field2[i][j + 1];
                            count++;
                        }
                    }

                    if((i+1)<=3){
                        if(field2[i+1][j]!=-1)
                            graph[field2[i][j]][count]=field2[i+1][j];

                    }
                    count=0;

                }
            }
        }

    }


    public int GetWay(int from,int to){
        Queue<Integer> queue = new LinkedList();
        queue.add(from);
        boolean []used=new boolean[size];
        int []p=new int[size];
        for(int i=0;i<size;i++){
            used[i]=false;
            p[i]=-1;
        }
        used[from]=true;
        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int i=0;i<4;i++){
                if(graph[v][i]>0 || (graph[v][i]==0 && i==0)){
                    if(!used[graph[v][i]]){
                        used[graph[v][i]]=true;
                        queue.add(graph[v][i]);
                        p[graph[v][i]]=v;
                    }
                }
            }

        }

        int path=0;
        for(int v=to;v!=-1;v=p[v])
        {

            path++;
        }
        return (path-1)*2;




    }

    public int FasterWay(){
        if(GetWay(start_vert,start_port)>GetWay(start_vert,finish_port)){
            int tmp=start_port;
            start_port=finish_port;
            finish_port=tmp;
        }
        else if(GetWay(start_vert,start_port)==GetWay(start_vert,finish_port)){
            if(GetWay(start_port,finish_vert)<GetWay(finish_port,finish_vert)){
                int tmp=start_port;
                start_port=finish_port;
                finish_port=tmp;
            }
        }
        int earth_path=GetWay(start_vert,finish_vert);
        int sea_path=GetWay(start_vert,start_port)+(GetWay(start_port,finish_port)/2+2)+GetWay(finish_port,finish_vert);

        if(earth_path>=sea_path)
            return sea_path;
        else
            return earth_path;
    }


}

