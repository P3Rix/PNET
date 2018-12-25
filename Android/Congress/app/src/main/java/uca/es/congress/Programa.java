package uca.es.congress;

public class Programa {

    private int imgFoto;
    private String horario;

    public Programa(int imgFoto, String horario) {
        this.imgFoto = imgFoto;
        this.horario = horario;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
