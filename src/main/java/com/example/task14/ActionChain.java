package com.example.task14;

import java.util.Random;

public class ActionChain
{
    Handler chain;
    public static int SUCCESS = 1;
    public static int NOTHING = 3;
    public static int LOSS = 2;
    Random generate;
    Player player;
    final int NUMHANDLER=3;
    final int NUMMAX = 4;

    public ActionChain(Player player)
    {
        this.player = player;
        generate =new Random();
        buildChain();
    }

    private void buildChain()
    {
        chain = new Nothing(new NegativeHandler(new PositiveHandler(null, player), player), player);
    }

    public boolean process()
    {
        int type=generate.nextInt(NUMHANDLER);//розыгрыш
        return process(type);
    }

    public boolean process(Integer a)
    {
        return chain.process(1+a%NUMHANDLER);//обрезка по числу имеющихся обработчиков
    }
}
