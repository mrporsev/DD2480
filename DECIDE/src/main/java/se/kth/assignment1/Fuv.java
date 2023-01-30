package se.kth.assignment1;

public class Fuv {

    private boolean[] fuv = new boolean[15];

    public Fuv(Pum pum, boolean[] PUV){
        Pum PUM = pum.getPum();

        for (int i = 0; i < 15; i++) {
            if (!PUV[i]) fuv[i] = true;
            else {
                fuv[i] = true;
                for (int j = 0; j < 15 ; j++) {
                    if(j != i && !PUM[i][j] ) {
                        fuv[i] = false;
                    }
                }
            }
        }
    }

    public boolean[] getFuv() {
        return fuv;
    }

    public boolean[] getElem(int i) {
        return fuv[i];
    }
}
