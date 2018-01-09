package com.company;

import java.util.*;

public class Field {
    private int mountain = -1, noPoint = -1;
    private int countOfStartPoints = 0, getCountOfFinishPoints = 0;
    private char[][] field;
    private int[][] graph;
    private Vector<Integer> ports = new Vector();
    private int start_vert = noPoint, finish_vert = noPoint, start_port, finish_port, size, size_matrix;

    public Field(char[] text) {

        char[] matrix = text;
        size_matrix = (int) Math.sqrt(matrix.length);
        field = new char[size_matrix][size_matrix];
        int elem = 0;
        for (int i = 0; i < size_matrix; i++) {
            for (int j = 0; j < size_matrix; j++) {
                field[i][j] = matrix[elem];
                elem++;
            }
        }
        int[][] field2 = new int[size_matrix][size_matrix];
        int count_vertex = 0;
        for (int i = 0; i < size_matrix; i++) {
            for (int j = 0; j < size_matrix; j++) {
                if (isStart(i, j)) {
                    start_vert = count_vertex;
                    countOfStartPoints++;
                }
                if (isFinish(i, j)) {
                    finish_vert = count_vertex;
                    getCountOfFinishPoints++;
                }
                if (isPort(i, j)) {
                    ports.add(count_vertex);
                }

                if (isMountain(i, j)) {
                    field2[i][j] = -1;
                    count_vertex--;
                } else
                    field2[i][j] = count_vertex;
                count_vertex++;

            }
        }
        if (ports.size() == 0 || start_vert == noPoint || finish_vert == noPoint) {
            throw new NoSuchElementException();
        }
        if (countOfStartPoints > 1 || getCountOfFinishPoints > 1) {
            throw new StackOverflowError();
        }


//
//
//
        size = count_vertex;
        graph = new int[count_vertex][4];
//
//

//
//      Graph initialization
//
        int count = 0;
        for (int i = 0; i < size_matrix; i++) {
            for (int j = 0; j < size_matrix; j++) {
                if (field2[i][j] != mountain) {
                    if (leftTopIndexInsideTheMatrix(i)) {
                        if (field2[i - 1][j] != mountain) {
                            graph[field2[i][j]][count] = field2[i - 1][j];
                            count++;
                        }
                    }

                    if (leftTopIndexInsideTheMatrix(j)) {
                        if (field2[i][j - 1] != mountain) {
                            graph[field2[i][j]][count] = field2[i][j - 1];
                            count++;
                        }
                    }

                    if (rightBottomIndexInsideTheMatrix(j)) {
                        if (field2[i][j + 1] != mountain) {
                            graph[field2[i][j]][count] = field2[i][j + 1];
                            count++;
                        }
                    }

                    if (rightBottomIndexInsideTheMatrix(i)) {
                        if (field2[i + 1][j] != mountain) {
                            graph[field2[i][j]][count] = field2[i + 1][j];
                            count++;
                        }

                    }
                    if (count == 0)
                        graph[field2[i][j]][count] = -1;
                    count = 0;

                }
            }
        }

    }

    public int GetWay(int from, int to) {
        Queue<Integer> queue = new LinkedList();
        queue.add(from);
        boolean[] used = new boolean[size];
        int[] p = new int[size];
        for (int i = 0; i < size; i++) {
            used[i] = false;
            p[i] = -1;
        }
        used[from] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (graph[v][i] > 0 || (graph[v][i] == 0 && i == 0)) {
                    if (!used[graph[v][i]]) {
                        used[graph[v][i]] = true;
                        queue.add(graph[v][i]);
                        p[graph[v][i]] = v;
                    }
                }
            }
        }

        int path = 0;
        for (int v = to; v != -1; v = p[v]) {
            path++;
        }

        return (path - 1) * 2;
    }

    public int fasterWay() {

        Vector<Integer> start_ports = new Vector();

        int min = size_matrix * size_matrix * 2;
        for (int i = 0; i < ports.size(); i++) {
            int portElement = (int) ports.elementAt(i);
            int way = GetWay(start_vert, portElement);
            if (way < min) {
                start_ports.clear();
                start_ports.add(portElement);
                min = way;
            } else if (way == min) {
                start_ports.add(portElement);
            }
        }

        //
        // find optimal start_port
        //
        start_port = (int) start_ports.firstElement();
        min = GetWay(start_port, finish_vert);
        for (int i = 1; i < start_ports.size(); i++) {
            int way = GetWay((int) start_ports.elementAt(i), finish_vert);
            if (way < min) {
                min = way;
                start_port = (int) start_ports.elementAt(i);
            }
        }
        ports.removeElement(start_port);
//
//      find optimal finish_ports
//
        min = size_matrix * size_matrix * 2;
        for (int i = 0; i < ports.size(); i++) {
            int portElement = (int) ports.elementAt(i);
            int way = GetWay(start_port, portElement) / 2 + 2 + GetWay(portElement, finish_vert);
            if (way < min) {
                finish_port = portElement;
                min = way;
            }

        }


        if (GetWay(start_vert, start_port) > GetWay(start_vert, finish_port)) {
            int tmp = start_port;
            start_port = finish_port;
            finish_port = tmp;
        } else if (GetWay(start_vert, start_port) == GetWay(start_vert, finish_port)) {
            if (GetWay(start_port, finish_vert) < GetWay(finish_port, finish_vert)) {
                int tmp = start_port;
                start_port = finish_port;
                finish_port = tmp;
            }
        }
        int earth_path = GetWay(start_vert, finish_vert);
        int sea_path;


        int btwn_strt_sport = GetWay(start_vert, start_port);
        int btwn_ports = GetWay(start_port, finish_port);
        if (btwn_ports != 0)
            btwn_ports = btwn_ports / 2 + 2;
        int btwn_fport_finish = GetWay(finish_port, finish_vert);
        if (btwn_strt_sport == 0 || btwn_ports == 0)
            sea_path = 0;
        else
            sea_path = btwn_strt_sport + btwn_ports + btwn_fport_finish;


        if (earth_path == 0)
            return 0;
        else if (earth_path >= sea_path && sea_path != 0)
            return sea_path;
        else
            return earth_path;

    }

    private boolean isStart(int i, int j) {
        if ((field[i][j] == 'S') || (field[i][j] == 's'))
            return true;
        return false;
    }

    private boolean isFinish(int i, int j) {
        if ((field[i][j] == 'F') || (field[i][j] == 'f'))
            return true;
        return false;
    }

    private boolean isPort(int i, int j) {
        if ((field[i][j] == 'P') || (field[i][j] == 'p'))
            return true;
        return false;
    }

    private boolean isMountain(int i, int j) {
        if (field[i][j] == '^')
            return true;
        return false;
    }

    private boolean leftTopIndexInsideTheMatrix(int i) {
        if (i - 1 >= 0)
            return true;
        return false;
    }

    private boolean rightBottomIndexInsideTheMatrix(int i) {
        if (i + 1 <= size_matrix - 1)
            return true;
        return false;
    }


}


