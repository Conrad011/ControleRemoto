

public class ControleRemoto implements Controlador {

    // Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;

    public  ControleRemoto(){
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if (this.getLigado()){
            System.out.println("----------MENU----------");
            System.out.println("Esta ligado? "+this.getLigado());
            System.out.println("Esta tocando? "+this.getTocando());
            System.out.println("Volume: "+this.getVolume());
            for (int i =0; i <= this.getVolume(); i+= 10){
                System.out.print("|");
            }
            System.out.println(getTocando());
        }else {
            System.out.println("O menu nao sera aberto. Ligue a TV");
        }
        }


    @Override
    public void fecharMenu() {
        System.out.println("fechando menu");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()){
            setVolume(this.getVolume() + 1);
        }else {
            System.out.println("Sua TV esta desligada. Impossivel aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if (getLigado()){
            setVolume(this.getVolume() - 1);
        }
        else {
            System.out.println("Sua TV esta desligada. Impossivel abaixar volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (getLigado() && getVolume() > 0){
            setVolume(0);
        }

    }

    @Override
    public void desligarMudo() {
        if (getLigado() && getVolume() == 0){
            setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }else {
            System.out.println("Nao consegui reproduzir");
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }else {
            System.out.println("Nao consegui pausar");
        }
    }
}
