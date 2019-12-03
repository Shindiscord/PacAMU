package amuEngine.physics;


public class LifeManager{

    private final int baseLives = 3;
    private int currentLives;

    public LifeManager(){
        this.currentLives=this.baseLives;
    }

    public int remove_life(){
        return this.currentLives--;
    }

    public int add_life(){
        return this.currentLives==3 ? 3 : this.currentLives++;
    }

    public int get_lives(){
        return this.currentLives;
    }


}