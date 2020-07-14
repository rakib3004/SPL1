package UserInterfacePackage;

import AHPalgorithm.AHPcalculation;
import AHPalgorithm.AHPprocessImplementation;
import FilePackage.DateTimeWriter;
import JavFX.FXThirdWindow;
import LibraryFunctionality.ReadingRoom;
import MainPackage.BookNumber;
import MainPackage.Processing;
import Methods.PrioritySort;
import MultiVariableRegression.MultipleLinearRegression;
import ObjectOriented.AHPcriteriaWeight;
import ObjectOriented.PriorityData;
import ProjectDescription.About;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AddBookFX extends Application {
    PriorityData[] priorityData;
    AHPcriteriaWeight ahPcriteriaWeight;
int positionLocator=85;
    int numberOfBooks;
    int iterator;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();
    MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
    AHPcalculation ahPcalculation = new AHPcalculation();
    AHPprocessImplementation ahPprocessImplementation = new AHPprocessImplementation();
    double writerWeight=0;
    double priceWeight=0;
    double typeWeight=0;

    @Override
    public void start(Stage primaryStage){
        String  className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter =  new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);        back.setOnAction(actionEvent -> {
            LibraryDesk libraryDesk = new LibraryDesk();
            try {
                libraryDesk.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        setStyle(exit);
        setStyle(back);
        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);

        Text bookNameText = new Text();
        Text writerNameText = new Text();
        Text typeNameText = new Text();
        Text bookPriceText = new Text();
        Text bookInformationText = new Text();
        bookNameText.setText("Book Name : ");
        writerNameText.setText("Writer Name : ");
        typeNameText.setText("Type Name : ");
        bookPriceText.setText("Book price : ");
        bookInformationText.setText("Book Info : ");
        setStyle(bookNameText);
        setStyle(writerNameText);
        setStyle(typeNameText);
        setStyle(bookPriceText);
        setStyle(bookInformationText);

        bookNameText.setFill(Color.GREENYELLOW);
        writerNameText.setFill(Color.GREENYELLOW);
        typeNameText.setFill(Color.GREENYELLOW);
        bookPriceText.setFill(Color.GREENYELLOW);
        bookInformationText.setFill(Color.GREENYELLOW);
        bookNameText.setTranslateX(200);
        writerNameText.setTranslateX(200);
        typeNameText.setTranslateX(200);
        bookPriceText.setTranslateX(200);
        bookInformationText.setTranslateX(200);

        bookNameText.setTranslateY(200-positionLocator);
        writerNameText.setTranslateY(300-positionLocator);
        typeNameText.setTranslateY(400-positionLocator);
        bookPriceText.setTranslateY(500-positionLocator);
        bookInformationText.setTranslateY(700-positionLocator);
        TextField bookNameTextField = new TextField("Nil Oporajita");
        TextField writerNameTextField = new TextField();
        TextField typeNameTextField = new TextField();
        TextField bookPriceTextField = new TextField();
        TextField bookInformationTextField = new TextField();

        setStyle(bookNameTextField);
        setStyle(writerNameTextField);
        setStyle(typeNameTextField);
        setStyle(bookPriceTextField);
        setStyle(bookInformationTextField);
        bookNameTextField.setTranslateX(450);
        writerNameTextField.setTranslateX(450);
        typeNameTextField.setTranslateX(450);
        bookPriceTextField.setTranslateX(450);
        bookInformationTextField.setTranslateX(450);

        bookNameTextField.setTranslateY(155-positionLocator);
        writerNameTextField.setTranslateY(255-positionLocator);
        typeNameTextField.setTranslateY(355-positionLocator);
        bookPriceTextField.setTranslateY(455-positionLocator);
        bookInformationTextField.setTranslateY(655-positionLocator);
        bookNameTextField.setPrefSize(400,60);
        writerNameTextField.setPrefSize(400,60);
        typeNameTextField.setPrefSize(400,60);
        bookPriceTextField.setPrefSize(400,60);
        bookInformationTextField.setPrefSize(850,60);

        MenuItem uponnash = new MenuItem("Uponnash");
        uponnash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
         typeNameTextField.setText(uponnash.getText());
            } });
        MenuItem kobita = new MenuItem("Kobita");
        kobita.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(kobita.getText());
            }
        });
        MenuItem rochonaboli = new MenuItem("Rochonaboli");
        rochonaboli.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(rochonaboli.getText());
            }
        });
        MenuItem religion = new MenuItem("Religion");
        religion.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(religion.getText());
            }
        });
        MenuItem biggan = new MenuItem("Biggan");
        biggan.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(biggan.getText());
            } });
        MenuItem sciFi = new MenuItem("Sci Fi");
        sciFi.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(sciFi.getText());
            }
        });
        MenuItem shishuShahitto = new MenuItem("Shishu Shahitto");
        shishuShahitto.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e)
            {
                typeNameTextField.setText(shishuShahitto.getText());
            }
        });
        MenuItem kisoreUponnash = new MenuItem("Kisore Uponnash");
        kisoreUponnash.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(kisoreUponnash.getText());
            } });
        MenuItem biography = new MenuItem("Biography");
        biography.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(biography.getText());
            }
        });
        MenuItem gobesona = new MenuItem("Gobesona");
        gobesona.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(gobesona.getText());
            }
        });
        MenuItem onubad = new MenuItem("Onubad");

        onubad.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {
                typeNameTextField.setText(onubad.getText());
            }
        });
        MenuItem others = new MenuItem("Others");
        others.setOnAction(new EventHandler<ActionEvent>() {
            @Override  public void handle(ActionEvent e) {

                typeNameTextField.setText(others.getText());
            }
        });
        MenuButton bookType = new MenuButton("Choose Your Type");
        bookType.getItems().addAll( uponnash, kobita, rochonaboli, religion,
                biggan, sciFi, shishuShahitto, kisoreUponnash,biography,
                gobesona, onubad,others);
        bookType.setTranslateX(880);
        bookType.setTranslateY(355-positionLocator);
        bookType.setPrefSize(200,55);
        MenuItem humayonAhmed = new MenuItem("Humayon Ahmed");
        humayonAhmed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
writerNameTextField.setText(humayonAhmed.getText());
            } });
        MenuItem muhammadJafarIqbal = new MenuItem("Muhammad Jafar Iqbal");

        muhammadJafarIqbal.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                writerNameTextField.setText(muhammadJafarIqbal.getText());
            }
        });
        MenuItem rokibHasan = new MenuItem("Rokib Hasan");
        rokibHasan.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(rokibHasan.getText());
            }
        });
        MenuItem emdadulHaqueMilon = new MenuItem("Emdadul Haque Milon");
        emdadulHaqueMilon.setOnAction(new EventHandler<ActionEvent>() {

            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(emdadulHaqueMilon.getText());
            }
        });
        MenuItem kaziNazrulIslam = new MenuItem("Kazi Nazrul Islam");
        kaziNazrulIslam.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(kaziNazrulIslam.getText());
            } });
        MenuItem kaziAnwarHossain = new MenuItem("Kazi Anwar Hossain");
        kaziAnwarHossain.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(kaziAnwarHossain.getText());
            }
        });
        MenuItem sharatChandraChattropadhay = new MenuItem("Sharat Chandra Chattropadhay");
        sharatChandraChattropadhay.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(sharatChandraChattropadhay.getText());
            }
        });
        MenuItem rabindranathTagore = new MenuItem("Rabindranath Tagore");
        rabindranathTagore.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(rabindranathTagore.getText());
            } });
        MenuItem sunilGangoPaddahay = new MenuItem("Sunil Gango Paddahay");
        sunilGangoPaddahay.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(sunilGangoPaddahay.getText());
            }
        });
        MenuItem samareshMajumdar = new MenuItem("Samaresh majumdar");
        samareshMajumdar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(samareshMajumdar.getText());
            }
        });
        MenuItem emdadiyaPustokaloy = new MenuItem("Emdadiya Pustokaloy");

        emdadiyaPustokaloy.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                writerNameTextField.setText(emdadiyaPustokaloy.getText());
            }
        });
        MenuButton writerMenu = new MenuButton("Choose The Writer");
        writerMenu.getItems().addAll( humayonAhmed, muhammadJafarIqbal, rokibHasan, emdadulHaqueMilon,
                kaziNazrulIslam, kaziAnwarHossain, sharatChandraChattropadhay, rabindranathTagore, sunilGangoPaddahay,
                samareshMajumdar, emdadiyaPustokaloy);
        writerMenu.setTranslateX(880);
        writerMenu.setTranslateY(255-positionLocator);
        writerMenu.setPrefSize(200, 55);
        MenuItem price1 = new MenuItem("120.00");
        price1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price1.getText());
            } });

        MenuItem price2 = new MenuItem("135.00");
        price2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price2.getText());
            }
        });
 MenuItem price3 = new MenuItem("140.00");
        price3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price3.getText());
            } });
        MenuItem price4 = new MenuItem("150.00");

        price4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price4.getText());
            }
        });
 MenuItem price5 = new MenuItem("160.00");
        price5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price5.getText());
            } });
        MenuItem price6 = new MenuItem("175.00");
        price6.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price6.getText());
            }
        });
 MenuItem price7 = new MenuItem("180.00");
        price7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price7.getText());
            } });
        MenuItem price8 = new MenuItem("190.00");

        price8.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price8.getText());
            }
        });
 MenuItem price9 = new MenuItem("200.00");
        price9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price9.getText());
            } });
        MenuItem price10 = new MenuItem("210.00");
        price10.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price10.getText());
            }
        });
 MenuItem price11 = new MenuItem("220.00");
        price11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price11.getText());
            } });
        MenuItem price12 = new MenuItem("250.00");
        price12.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price12.getText());
            }
        });
 MenuItem price13 = new MenuItem("270.00");
        price13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price13.getText());
            } });
        MenuItem price14 = new MenuItem("280.00");
        price14.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price14.getText());
            }
        });
 MenuItem price15 = new MenuItem("300.00");
        price15.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price15.getText());
            } });
        MenuItem price16 = new MenuItem("320.00");

        price16.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price16.getText());
            }
        });
 MenuItem price17 = new MenuItem("350.00");
        price17.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bookPriceTextField.setText(price17.getText());
            } });
        MenuItem price18 = new MenuItem("375.00");

        price18.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price18.getText());
            }
        });
 MenuItem price19 = new MenuItem("400.00");
        price19.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               bookPriceTextField.setText(price19.getText());

            } });
        MenuItem price20 = new MenuItem("500.00");

        price20.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                bookPriceTextField.setText(price20.getText());
            }
        });
        MenuButton priceMenu = new MenuButton("Select Book Price");
        priceMenu.getItems().addAll(price1,price2,price3,price4,
                price5,price6,price7,price8,price9,price10,price11,
                price12,price13,price14,price15,price16,price17,
                price18,price19,price20);
        priceMenu.setTranslateX(880);
        priceMenu.setTranslateY(455-positionLocator);
        priceMenu.setPrefSize(200, 55);
        Button addItem = new Button("Add Item");
        addItem.setTranslateX(480);
        addItem.setTranslateY(450);
        addItem.setOnAction(actionEvent -> {

                bookInformationTextField.setText(bookNameTextField.getText()+"-"+
                        writerNameTextField.getText()+"-"+typeNameTextField.getText()+
                        "-"+bookPriceTextField.getText());
                double newBookPrice = Double.parseDouble(bookPriceTextField.getText());

                int writerCounter=0;
                int priceCounter=0;
                int typeCounter=0;

                String upperBookPrice,lowerBookPrice;
                double upperBookPriceRange;
                double lowerBookPriceRange;
                double newBookPriceValue;
                newBookPriceValue =newBookPrice;
                boolean isGetAnyWriter = false;
                boolean isGetAnyType = false;
                boolean isGetSimilarPrice = false;
            try {
                numberOfBooks = bookNumber.bookNumberFindingMethods();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                priorityData = processing.fileReaderMethods();
            } catch (IOException e) {
                e.printStackTrace();
            }
            priorityData = multipleLinearRegression.multipleLinearRegressionMethods(priorityData,numberOfBooks);
                newBookPriceValue = Double.parseDouble(bookPriceTextField.getText());

                                for(iterator=0;iterator<numberOfBooks;iterator++){
                upperBookPrice = priorityData[iterator].bookData.bookPrice;
                lowerBookPrice = priorityData[iterator].bookData.bookPrice;

                upperBookPriceRange = Double.parseDouble(upperBookPrice)+30.00;
                lowerBookPriceRange = Double.parseDouble(lowerBookPrice)-30.00;
                if(newBookPriceValue<=upperBookPriceRange&&newBookPriceValue>=lowerBookPriceRange){
                    priceWeight = priceWeight + priorityData[iterator].getMLRweight();
                    priceCounter++;
                    isGetSimilarPrice = true;
                }
                }
                for(iterator=0;iterator<numberOfBooks;iterator++){

                    if(priorityData[iterator].bookData.writerName.equals(writerNameTextField.getText())){
                        writerWeight = writerWeight+priorityData[iterator].getMLRweight();
                        writerCounter++;
                        isGetAnyWriter = true;
                    }
                }
               for(iterator=0;iterator<numberOfBooks;iterator++){

                    if(priorityData[iterator].bookData.getTypeName().equals(typeNameTextField.getText())){
                        typeWeight = typeWeight+priorityData[iterator].getMLRweight();
                        typeCounter++;
                        isGetAnyType = true;
                    }
                }
                if(isGetAnyType==true){
                    typeWeight = typeWeight/typeCounter;
                }
                if(isGetAnyWriter==true){
                    writerWeight = writerWeight/writerCounter;
                }
                if(isGetSimilarPrice==true){
                    priceWeight = priceWeight/priceCounter;
                }
                int maxPriorityDataIndex=0;

                PrioritySort prioritySort = new PrioritySort();
                priorityData = prioritySort.PrioritySortingMLRmethods(priorityData,numberOfBooks);
                double comparingDataValue = priorityData[maxPriorityDataIndex].getMLRweight();

                double writerPrediction,typePrediction,pricePrediction;
                writerPrediction =(writerWeight/comparingDataValue)*100;
                typePrediction = (typeWeight/comparingDataValue)*100;
                pricePrediction = (priceWeight/comparingDataValue)*100;
                //double terminalPrediction = (.37*writerPrediction) + (.43*typePrediction) + (.2 *pricePrediction);
            double terminalPrediction = ((.370*writerPrediction)+(.430*typePrediction)+(.200*pricePrediction));
            terminalPrediction = Math.round(terminalPrediction*100.00)/100.00;
            typeWeight = Math.round(typeWeight*100.00)/100.00;
            writerWeight = Math.round(writerWeight*100.00)/100.00;
            priceWeight = Math.round(priceWeight*100.00)/100.00;

                Label label4= new Label("Type Predicted  : "+typeWeight+"%\n" +
                        "Writer Predicted : "+writerWeight+"%\n" +
                        "Price Predicted : "+priceWeight+"%\n");
            Label label3 = new Label();
            /*"Tool recommended "+terminalPrediction+"%\n"+
                    "to add this book \n"+"in the Library"*/
               String string ="Low Quality's Book";
               String string1 ="Medium Quality's Book";
               String string2 ="High Quality's Book";
               String string3 ="New Type's Book";
               if(terminalPrediction<35.00){
                   label3.setText(string);
               }
               else  if(terminalPrediction<75.00){
                   label3.setText(string1);
               }
 else {
     label3.setText(string2);
               }

                setStyle(label3);

                // TextField Ve = new TextField();
            Button analysis = new Button("Analysis");
            analysis.setPrefSize(160,40);
            Stage infoStage = new Stage();
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
                gridPane.add(label3,1,1,5,5);
                gridPane.add(analysis,3,6,1,1);
                setStyle2(analysis);
                Scene S = new Scene(gridPane, 290, 165);
                infoStage.setTitle("Add Book");
                infoStage.setScene(S);
                infoStage.show();
            analysis.setOnAction(actionEvent1 -> {
            setStyle2(label4);

                Label label1a = new Label("Type Priority :");
                Label label1b = new Label("Writer Priority :");
                Label label1c = new Label("Price Priority :");
                label1a.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                label1b.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                label1c.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            typeWeight = 2*typeWeight/100.00;
            writerWeight = 2*writerWeight/100.00;
            priceWeight = 2*priceWeight/100.00;
                ProgressBar progressBar = new ProgressBar(typeWeight);
                ProgressBar progressBar1 = new ProgressBar(writerWeight);
                ProgressBar progressBar2 = new ProgressBar(priceWeight);
                label1a.setLabelFor(progressBar);
                label1b.setLabelFor(progressBar1);
                label1c.setLabelFor(progressBar2);
                progressBar.setStyle("-fx-accent: orange");
                progressBar1.setStyle("-fx-accent: blue");
                progressBar2.setStyle("-fx-accent: green");
                label1a.setMnemonicParsing(true);
                label1b.setMnemonicParsing(true);
                label1c.setMnemonicParsing(true);
                Stage analysisStage = new Stage();
                GridPane subGridPane = new GridPane();
                subGridPane.addRow(0,label1a,progressBar);
                subGridPane.addRow(1,label1b,progressBar1);
                subGridPane.addRow(2,label1c,progressBar2);
                subGridPane.setAlignment(Pos.CENTER);
            //    subGridPane.add(label4,1,1,5,5);
                Scene scene2 = new Scene(subGridPane, 290, 165);
                analysisStage.setTitle("Add Book");
                analysisStage.setScene(scene2);
                analysisStage.show();
            });

        });

        setStyle(addItem);
        addItem.setPrefSize(220, 65);

        Image image = new Image("Images"+ File.separator +"libraryBackground6.jpg");
        Canvas canvas = new Canvas(1500,950);
        Group group = new Group();
        group.getChildren().addAll(canvas,exit,back,bookNameText,writerNameText,
                typeNameText,bookPriceText,bookInformationText,bookNameTextField,
                writerNameTextField,typeNameTextField,
                bookPriceTextField,bookInformationTextField,
                addItem,bookType,writerMenu,priceMenu);
            GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(image,0,0);
        Scene scene1 = new Scene(group,1500,950);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Books Statistics");
       // primaryStage.setFullScreen(true);
        primaryStage.show();
    }
        public Button setStyle( Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }  public Button setStyle2( Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.3em;");
        return  button;
    }
    public Text setStyle(Text text)
    {
        text.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  text;
    }

 public Label setStyle(Label label)
    {
        label.setStyle("-fx-background-color: \n" +
                "        #090a0c,\n" +
                "                linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "        -fx-background-radius: 5,4,3,5;\n" +
                "        -fx-background-insets: 0,1,2,0;\n" +
                "        -fx-text-fill: white;\n" +
                "        -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "        -fx-font-family: \"Arial\";\n" +
                "        -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "        -fx-font-size: 1.5em;\n" +
                "        -fx-padding: 10 20 10 20;");
        return  label;
    }
 public Label setStyle2(Label label)
    {
        label.setStyle("-fx-background-color: \n" +
                "        #090a0c,\n" +
                "                linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "        -fx-background-radius: 5,4,3,5;\n" +
                "        -fx-background-insets: 0,1,2,0;\n" +
                "        -fx-text-fill: white;\n" +
                "        -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "        -fx-font-family: \"Arial\";\n" +
                "        -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "        -fx-font-size: 1.5em;\n" +
                "        -fx-padding: 10 20 10 20;");
        return  label;
    }
    public TextField setStyle2(TextField textField)
    {
        textField.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color:\n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  textField;
    }  public TextField setStyle(TextField textField)
    {
        textField.setStyle("-fx-background-color: \n" +
        "        #090a0c,\n" +
                "                linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "        -fx-background-radius: 5,4,3,5;\n" +
                "        -fx-background-insets: 0,1,2,0;\n" +
                "        -fx-text-fill: white;\n" +
                "        -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "        -fx-font-family: \"Arial\";\n" +
                "        -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "        -fx-font-size: 1.5em;\n" +
                "        -fx-padding: 10 20 10 20;");
        return  textField;
    }
}