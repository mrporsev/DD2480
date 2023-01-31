package se.kth.assignment1;

public class Fuv {

    private boolean[] fuv = new boolean[15];

    public Fuv(Pum pum, boolean[] PUV){
        boolean[][] PUM = pum.getPum();

        this.fuv = setFuv(PUM, PUV);
    }

    public boolean[] getFuv() {
        return fuv;
    }

    public boolean getElem(int i) {
        return fuv[i];
    }

    protected boolean[] setFuv(boolean[][] PUM, boolean[] PUV) {
        boolean[] f = new boolean[15];
        for (int i = 0; i < 15; i++) {
            if (!PUV[i]) f[i] = true;
            else {
                f[i] = true;
                for (int j = 0; j < 15 ; j++) {
                    if(j != i && !PUM[i][j] ) {
                        f[i] = false;
                    }
                }
            }
        }
        return f;
    }
}
