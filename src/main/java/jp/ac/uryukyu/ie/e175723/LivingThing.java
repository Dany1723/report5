package jp.ac.uryukyu.ie.e175723;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public int getHitPoint(){return hitPoint;}
    public int getAttack(){return attack;}
    public boolean getDead(){return dead;}

    public void setName(String name) {this.name = name;}
    public void setHitPoint(int hitPoint) {this.hitPoint = hitPoint;}
    public void setAttack(int attack) {this.attack = attack;}
    public void setDead(boolean dead) {this.dead = dead;}

    public LivingThing (String name, int hitPoint, int attack){
        this.name=name;
        this.hitPoint=hitPoint;
        this.attack=attack;
    }
    public boolean isDead() {
        return dead;
    }

    public String getName(){
        return name;
    }



    public void attack(LivingThing opponent){
        if( dead==false) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }


}

