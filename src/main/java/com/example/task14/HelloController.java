package com.example.task14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ImageView view1,view2,view3;
    public HBox bags;
    public Label coinsCount;
    public Label trying;

    //создание объекта
    ActionChain action;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        view1.setImage(new Image("bag.png"));
        view2.setImage(new Image("bag.png"));
        view3.setImage(new Image("bag.png"));
        action=new ActionChain(player1);//запуск механизма розыгрыша
        bags.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (player1.getNumber()==0) init();
            if(action==null) return;//если цепочка обработки отсутствует
            if (action.process()) init();//продолжить играть и проверить наличия монетки у игрока
            else action=null;//завершить игру, сделав обработку недоступной
    });}

    public Player player1 = new Player("Игрок", 0);
    public void onPay(ActionEvent actionEvent) {  player1.addNumber(1); }

    public boolean init()
    {
        if(! player1.pay(1))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Нехватка монет. Когда появятся деньги, приходите ещё!");
            ButtonType oki = new ButtonType("Выйти и забыть", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(oki);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().getButtonData() == ButtonBar.ButtonData.NO)
                exit();
            action=null;
            return false;
        }
        else return true;
    }

    public void exit(){System.exit(0);}
    public void MouseHover1(MouseEvent mouseEvent) { view1.setImage(new Image("bag_outline.png"));  }
    public void MouseOff1(MouseEvent mouseEvent) { view1.setImage(new Image("bag.png"));  }
    public void MouseHover2(MouseEvent mouseEvent) { view2.setImage(new Image("bag_outline.png"));  }
    public void MouseOff2(MouseEvent mouseEvent) { view2.setImage(new Image("bag.png"));  }
    public void MouseHover3(MouseEvent mouseEvent) { view3.setImage(new Image("bag_outline.png")); }
    public void MouseOff3(MouseEvent mouseEvent) { view3.setImage(new Image("bag.png"));  }
    public void statusShow() {
        coinsCount.setText(player1.getNumber().toString());
        trying.setText(player1.getCount().toString());
    }
}