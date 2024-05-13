package models;

import models.Lugar;

public class Planta {
    private Lugar[][] M;

    public Planta(int n, int m) {
        this.M = new Lugar[n][m];
    }

    public Lugar[][] getM() {
        return this.M;
    }


    public void setM(Lugar[][] m) {

    }
    public void displayM() {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j].state == 0) {
                    System.out.print("|_|" + "\t");
                } else if (M[i][j].state == -1) {
                    System.out.print("---" + "\t");
                } else if (M[i][j].state == 1) {
                    System.out.print("|x|" + "\t");
                } else {
                    System.out.print(" " + M[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
