package com.example.task14;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static com.example.task14.ActionChain.LOSS;

public class NegativeHandler extends Handler{
    Player player;
    public NegativeHandler(Handler processor, Player player)
    {
        super(processor);
        this.player = player;
    }

    public boolean process(Integer request)
    {
        if (request != LOSS) return super.process(request);// не свой запрос передается дальше по цепочке
        else
        {//свой, обрабатывается здесь
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Проигрыш!");
            alert.setHeaderText("Вы проиграли, попробуйте отыграться!");
            ButtonType replay = new ButtonType("Продолжить тратить время", ButtonBar.ButtonData.YES);
            ButtonType vacation = new ButtonType("Выйти и забыть", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(replay,vacation);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
                return true;
            else
                System.exit(0);
                return false;
        }
    }}
