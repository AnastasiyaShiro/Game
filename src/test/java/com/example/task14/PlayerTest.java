package com.example.task14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{
    Player player;

    @BeforeEach
    void setUp()
    {
        player=new Player("Петя",0);
    }

    @Test
    void getCount()
    {
        Assertions.assertEquals(player.getCount(),0);
    }
}