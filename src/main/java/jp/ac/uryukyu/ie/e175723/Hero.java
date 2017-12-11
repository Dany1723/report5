package jp.ac.uryukyu.ie.e175723;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing{
   /* String name;
    int hitPoint;
    int attack;
    boolean dead; */

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
        setdeathMassage("勇者%sは道半ばで力尽きてしまった。\n");
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    @Override
    public void attack(LivingThing opponent){
        boolean de = getDead();
        String na = getName();
        int at = getAttack();
        if(de==false){
            int damage=(int)(Math.random()*at);
            int critical=(int)(Math.random()*10);
            if(damage==0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", na,opponent.getName(),damage);
            }else{
                if(critical<=4) {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", na, opponent.getName(), damage);
                    opponent.wounded(damage);
                }else{
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", na, opponent.getName(), damage*2);
                    opponent.wounded(damage*2);
                }
            }
        }
    }
}