/*
 * Coded By AJITH KP [ ajithkp560@gmail.com ]
 * AMSTECK ARTS & SCIENCE COLLEGE, KALLIASSERY
 * BCA 2012 - 2015 Batch
 */
package quizprogram;


import static java.lang.Math.random;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
public class SampleController implements Initializable 
{     
    static final Integer START = (30*60)+2;
    Integer timesec = START;
    Integer[] val = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static Integer qno = 0;
    static Integer qnum = 0;
    static float score = 0;
    public String ans;
    static final String[] questions = {"Identify the person.", //1
                                       "Identify the person.", //2
                                       "Identify the person.", //3
                                       "Identify the person.", //4
                                       "What menu is selected to insert page number\n in a word format?", //5
                                       "One byte means?", //6
                                       "_____ is not an action of mouse.", //7
                                       "_____ is a protocol used for e-mail.", //8
                                       "URL stands for.", //9
                                       "IPv4 uses _____ addresses.", //10
                                       "Computer error is known as.", //11
                                       "The path to a file named January in a folder\n named budgets on drive D is _____.", //12
                                       "Internet is a _____.", //13
                                       "Which of the following express the largest unit\n for storing the data?", //14
                                       "Which is latest version of android?", //15
                                       "Who invented C++ ?", //16
                                       "Process of finding/correcting\n program errors is _____.", //17
                                       "What language does the computer\n use and understand?", //18
                                       "Who is the new CEO of Microsoft?", //19
                                       "What are three types of networks?", //20
                                       "_____ is a translator system  program used to\n translate a High-level language program into a\n Machine language program", //21
                                       "Who is considered to be\n the first programmer?", //22
                                       "What is default port number for\n Apache and most web servers?", //23
                                       "What type of memory is volatile?", //24
                                       "What is the input device primarily\n used with a PDA?", //25
                                       "Which of the bellow is not related\n to the Internet and web developement?", //26
                                       "Which of the following is not an\n Antivirus company?", //27
                                       "Who created the first mouse?", //28
                                       "Which of the bellow is the\n GUI commonly used with Linux?", //29
                                       "How much disk space does a standard\n Compact Disc hold?" //30
                                        };
    
    static final String[] answers = {"Charles Babbage", //1
                                     "Steve Jobs", //2
                                     "Tim Berners-Lee", //3
                                     "Mark Zuckerberg", //4
                                     "Insert", //5
                                     "8 bits", //6
                                     "Copy", //7
                                     "SMTP", //8
                                     "Uniform Resource Locator", //9
                                     "32-bit", //10
                                     "BUG", //11
                                     "D:/budgets/January", //12
                                     "WAN", //13
                                     "Tb", //14
                                     "KitKat", //15
                                     "Bjarne Stroustrup", //16
                                     "Debugging", //17
                                     "Machine", //18
                                     "Satya Nadella", //19
                                     "LAN, MAN, WAN", //20
                                     "Compilers", //21
                                     "Ada Lovelace", //22
                                     "80", //23
                                     "RAM", //24
                                     "Stylus", //25
                                     "DOS", //26
                                     "Xargon", //27
                                     "Douglas Englebart", //28
                                     "GNOME", //29
                                     "700 MB" //30
                                     };
    
    static final String[][] options = {{"Dennis Ritchie", "Charles Babbage", "Bjarne Stroustrup", "Isaac Newton"}, //1
                                       {"Bill Gates", "Mark Zuckerberg", "James Gosling", "Steve Jobs"}, //2
                                       {"Tim Berners-Lee", "Donald Knuth", "Lewis Steele", "Harold Abelson"}, //3
                                       {"John Carmack", "John Resig", "Brian Cohen", "Mark Zuckerberg"}, //4
                                       {"File", "Edit", "Tool", "Insert"}, //5
                                       {"8 bits", "32 bits", "4 bits", "1024 bits"}, //6
                                       {"Copy", "Click", "Double click", "Drag"}, //7
                                       {"TCP/IP", "HTTP", "SMTP", "FTP"}, //8
                                       {"Uniform Resource Locator", "Universal Research Locator", "Uniform Research Locator", "Universal Resource Launcher"}, //9
                                       {"16-bit", "32-bit", "64-bit", "128-bit"}, //10
                                       {"BUG", "RAM", "ALU", "ROM"}, //11
                                       {"D:\\budgets\\january", "D:\\january\\budgets", "D:/January/budgets", "D:/budgets/January",}, //12
                                       {"WAN", "LAN", "CHAIN", "Intranet work"}, //13
                                       {"Gb", "Kb", "Mb", "Tb"}, //14
                                       {"Ginger Bread",  "KitKat", "Jelly Bean", "IceCreamSandwich"}, //15
                                       {"James Gosling", "Ken Thompson", "Bjarne Stroustrup", "Dennis Ritchie"}, //16
                                       {"Bugs","Debugging","Hacking","Cracking"}, //17
                                       {"High-level","Assemby","Machine","None of these"}, //18
                                       {"Bill Gates","Satya Nadella", "Steve Ballmer", "Larry Page"}, //19
                                       {"LAN, MAN, WAN", "LAN, TAN, WAN", "LAN, SAN, WAN", "LAN, PAN, WAN"}, //20
                                       {"Compilers", "Assemblers", "Interpreters", "All the above"}, //21
                                       {"Ada Lovelace", "Alan Turing", "Bill Gates", "Brian Kernighan"}, //22
                                       {"20" , "23", "80", "887"}, //23
                                       {"Cache", "Hard Drive", "RAM", "ROM"}, //24
                                       {"Keyboard", "Mouse", "Scanner", "Stylus"}, //25
                                       {"DOS", "HTML", "Java", "PHP"}, //26
                                       {"AVG", "Panda", "Symantech", "Xargon"}, //27
                                       {"Steve Jobs", "Douglas Englebart", "John Mauchly", "Robert Noyce"}, //28
                                       {"LUI", "GNU", "GNOME", "GPL"}, //29
                                       {"200 MB", "500 MB", "700 MB", "4.7 GB"} //30
                                      };//{"Berndan Eich & James Gosling","Rasmus Lerdorf & Ken Thompson","Brian Kernighan & Mattmullenweg","Jancoun & Brian Acton"}
    
    static final Integer[] imgx = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    final ToggleGroup group = new ToggleGroup();
    Timeline timeline = null;
    Stage stage;
    KeyCodeCombination kb, finished, scoreS;
    @FXML
    AnchorPane optionPane, finishx;
    @FXML
    Rectangle unlocktop, unlockbottom;
    @FXML
    private Node root;
    @FXML
    Label timex, question, bcarock, qsno, scoreB;
    @FXML
    Button button, button2, lock, subm;
    @FXML
    RadioButton a1, a2, a3, a4;
    
    @FXML
    private void nextQ(ActionEvent event) 
    {   
        next();
    }
    
    @FXML
    private void prevQ(ActionEvent event)
    {
        prev();
    }
    
    @FXML
    private void submitted(ActionEvent event)
    {
        if(group.getSelectedToggle()!=null)
        {
            val[qno] = 1;  
            if(ans.equals(answers[qno]))
            {
                score+=1;
            }
            else
            {
                score-=0.25;
            }
            check();
            //setScore();
            next();
        }
    }
    
    @FXML
    private void unlockPressed(ActionEvent event)
    {
        //Thanks to Oracle Tutorial for this animation;
        lock.setDisable(true);
        root.requestFocus();
        final FadeTransition fadeLockButton = fadeOut(Duration.valueOf("1s"), lock);
        final FadeTransition fadeBca = fadeOut(Duration.valueOf("1s"), bcarock);
        final heightTrans openLockTop = new heightTrans(Duration.valueOf("2s"), unlocktop);
        openLockTop.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args) {
                unlocktop.setVisible(false);
                unlocktop.setHeight(openLockTop.height);
            }
        });
        final heightTrans openLockBottom = new heightTrans(Duration.valueOf("2s"), unlockbottom);
        openLockBottom.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args) {
                unlockbottom.setVisible(false);
                unlockbottom.setHeight(openLockBottom.height);
            }
        });
        final ParallelTransition openLock = new ParallelTransition(openLockTop, openLockBottom);
        final SequentialTransition unlock = new SequentialTransition(fadeLockButton, openLock); 
        final SequentialTransition bca = new SequentialTransition(fadeBca, openLock); 
        unlock.play();
        bca.play();
               
        if(timeline != null)
        {
            timeline.stop();
        }
        timesec = START;
        timex.setText("Time Left: "+(timesec/60)+":"+(timesec%60));
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                new EventHandler()
                {
                    @Override
                    public void handle(Event t) 
                    {
                        timesec--;
                        timex.setText("Time Left: "+(timesec/60)+":"+(timesec%60));
                        if(timesec<=0)
                        {
                            timeline.stop();
                            question.setText("Time Out!!!\nYour Score is "+score);
                            root.setDisable(true);
                            finishQ();
                        }
                    }                    
                }));
        timeline.playFromStart();                
        question.setText(questions[qno]);
        qsno.setText("Question Number: 1");
        //scoreB.setText("Score: "+score);
        
        if(imgx[qno]==1 && val[qno]==0)
        {
            showImage(qno);
        }
        
        setOptionsx();
    }
    
    @FXML
    private void mouseOver(MouseEvent event)
    {
        button.setStyle("-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
"	-fx-background-insets:0, 1, 2;\n" +
"	-fx-background-radius: 30;\n" +
"	-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 3, 0.0, 0, 1);\n" +
"	-fx-padding: 3 30 3 30;\n" +
"	-fx-text-fill: #242d35;\n" +
"	-fx-font-size: 14px;");
    }
    
    @FXML
    private void mouseOver2(MouseEvent event)
    {
        button2.setStyle("-fx-background-color:#3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
"	-fx-background-insets:0, 1, 2;\n" +
"	-fx-background-radius: 30;\n" +
"	-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 3, 0.0, 0, 1);\n" +
"	-fx-padding: 3 30 3 30;\n" +
"	-fx-text-fill: #242d35;\n" +
"	-fx-font-size: 14px;");
    }
    
    @FXML
    private void mouseOver3(MouseEvent event)
    {
        subm.setStyle("-fx-background-color:rgba(0,0,0,0,0.08), linear-gradient(#5a61af, #51536d), linear-gradient(#e4fbff 0%, #cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
"	-fx-background-insets:0, 1, 2;\n" +
"	-fx-background-radius: 70;\n" +
"	-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 3, 0.0, 0, 1);\n" );
    }
    
    @FXML
    private void mouseExit1(MouseEvent event)
    {
        button.setStyle("-fx-background-color:rgba(0,0,0,0,0.08), linear-gradient(#5a61af, #51536d), linear-gradient(#e4fbff 0%, #cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
"	-fx-background-insets: 0 0 -1 0, 0, 1;\n" +
"	-fx-background-radius: 30;\n" +
"	-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 3, 0.0, 0, 1);\n" +
"	-fx-padding: 3 30 3 30;\n" +
"	-fx-text-fill: #242d35;\n" +
"	-fx-font-size: 14px;");
    }
    
    @FXML
    private void mouseExit2(MouseEvent event)
    {
        button2.setStyle("-fx-background-color:rgba(0,0,0,0,0.08), linear-gradient(#5a61af, #51536d), linear-gradient(#e4fbff 0%, #cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
"	-fx-background-insets: 0 0 -1 0, 0, 1;\n" +
"	-fx-background-radius: 30;\n" +
"	-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 3, 0.0, 0, 1);\n" +
"	-fx-padding: 3 30 3 30;\n" +
"	-fx-text-fill: #242d35;\n" +
"	-fx-font-size: 14px;");
    }
    
    @FXML
    private void mouseExit3(MouseEvent event)
    {
        subm.setStyle("-fx-background-color:rgba(0,0,0,0,0.08), linear-gradient(#5a61af, #51536d), linear-gradient(#e4fbff 0%, #cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\n" +
"       -fx-background-radius: 70;\n"+
"	-fx-background-insets: 0 0 -1 0, 0, 1;\n" +
"	-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.6), 3, 0.0, 0, 1);\n");
    }
    
    @FXML
    private void KeyPressed(KeyEvent event)
    {
        if(kb.match(event))
        {
            if(imgx[qno] == 1 && val[qno] == 0)
            {
                showImage(qno);
            }
        }
        if(finished.match(event))
        {
            finishQ();
        }
        if(scoreS.match(event))
        {
            setScore();
        }
    }
    
    @FXML
    private void KeyRel(KeyEvent event)
    {
        if(scoreS.match(event))
        {
            scoreB.setText("");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        finishx.setVisible(false);
        kb = new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN);
        finished = new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN);
        scoreS = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
        Random rand = new Random();
        qno = rand.nextInt(questions.length);
        a1.setToggleGroup(group);
        a2.setToggleGroup(group);
        a3.setToggleGroup(group);
        a4.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
           @Override
           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle)
           {
               if(group.getSelectedToggle()!=null)
               {
                   ans = ((RadioButton) new_toggle).getText();
               }
           }
        });
    }    
    
    private void check()
    {
        if(val[qno]==1)
        {
            optionPane.setDisable(true);
        }
        else
        {
            optionPane.setDisable(false);            
            a1.setSelected(false);
            a2.setSelected(false);
            a3.setSelected(false);
            a4.setSelected(false);
        }
    }
    
    private void setOptionsx()
    {       
        a1.setText(options[qno][0]);
        a2.setText(options[qno][1]);
        a3.setText(options[qno][2]);
        a4.setText(options[qno][3]);
    }
    
    private void showImage(Integer qn)
    {   
        final ImageView imv = new ImageView(new Image(getClass().getResourceAsStream(qn.toString()+".png")));
        stage  = new Stage();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("apple.png")));
        stage.initModality(Modality.APPLICATION_MODAL);
        StackPane pane2 = new StackPane();
        pane2.getChildren().add(imv);
        double wid = imv.getImage().getWidth();
        double hei = imv.getImage().getHeight();
        Scene scene = new Scene(pane2, wid, hei);
        stage.setScene(scene);
        stage.setTitle("Identify the person...");
        stage.show();
    }

    private void next() 
    {    
        try
        {
            stage.close();
        }
        catch(Exception e)
        {
            
        }
        
        qno++;
        qnum++;
        qno = (qno%questions.length);
        qnum = (qnum%questions.length);
        
        if(imgx[qno]==1 && val[qno]==0)
        {
            showImage(qno);
        }
        
        check();
        question.setText(questions[qno]);
        qsno.setText("Question Number: "+(qnum+1));
        setOptionsx();
    }

    private void prev() 
    {
        try
        {
            stage.close();
        }
        catch(Exception e)
        {
            
        }
        
        if(qno==0)
        {
            qno = questions.length;
        }
        if(qnum==0)
        {
            qnum = questions.length;
        }
        qno--;
        qnum--;
        qno = (qno%questions.length);
        qnum = (qnum%questions.length);
        setOptionsx();
        check();
        question.setText(questions[qno]);
        qsno.setText("Question Number: "+(qnum+1));
        
        
        if(imgx[qno]==1 && val[qno]==0)
        {
            showImage(qno);
        }
    }
    
    private void setScore()
    {
        scoreB.setText("Score: "+score);
    }
        
    private final static class heightTrans extends Transition 
    {
        final Rectangle node;
        final double height;

        public heightTrans(Duration duration, Rectangle node) 
        {
            this(duration, node, node.getHeight());
        }

        public heightTrans(Duration duration, Rectangle node, double height) 
        {
            this.node = node;
            this.height = height;
            this.setCycleDuration(duration);
        }

        public Duration getDuration() 
        {
            return getCycleDuration();
        }

        @Override
        protected void interpolate(double frac) 
        {
            node.setHeight((1.0 - frac) * height);
        }
    }
    
    private void finishQ()
    {
        //Thanks to Oracle Tutorial for this animation;
        Text t = new Text("Your Score: "+score);
        t.setFont(Font.font("Algerian", 50));
        t.setFill(Color.YELLOWGREEN);
        t.setCache(true);
        t.setTranslateY(320);//296
        t.setTranslateX(210);//210
        finishx.setVisible(true);
        Group circ = new Group();
        
        for(int i=0;i<25;i++)
        {
            Circle c = new Circle(150, Color.web("white", 0.05));
            c.setStrokeType(StrokeType.OUTSIDE);
            c.setStroke(Color.web("white", 0.16));
            c.setStrokeWidth(4);
            c.setEffect(new BoxBlur(10,10,3));
            circ.getChildren().add(c);
        }
        
        Rectangle col = new Rectangle(finishx.getWidth(), finishx.getHeight(), new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
                                        new Stop(0,    Color.web("#f8bd55")),
                                        new Stop(0.14, Color.web("#c0fe56")),
                                        new Stop(0.28, Color.web("#5dfbc1")),
                                        new Stop(0.43, Color.web("#64c2f8")),
                                        new Stop(0.57, Color.web("#be4af7")),
                                        new Stop(0.71, Color.web("#ed5fc2")),
                                        new Stop(0.85, Color.web("#ef504c")),
                                        new Stop(1,    Color.web("#f2660f")),}));
        col.widthProperty().bind(finishx.widthProperty());
        col.heightProperty().bind(finishx.heightProperty());
        Group grp = new Group(new Group(new Rectangle(finishx.getWidth(), finishx.getHeight(), Color.BLACK), circ), col);
        col.setBlendMode(BlendMode.OVERLAY);
        finishx.getChildren().add(grp);
        Timeline tm = new Timeline();
        for(Node cir: circ.getChildren())
        {
            tm.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(cir.translateXProperty(), random()*800), new KeyValue(cir.translateYProperty(), random()*600)), new KeyFrame(new Duration(20000), new KeyValue(cir.translateXProperty(), random()*800), new KeyValue(cir.translateYProperty(), random()*600)));
        }
        tm.setCycleCount(Timeline.INDEFINITE);
        tm.setAutoReverse(true);
        tm.play();        
        finishx.getChildren().add(t);
    }
    
    private FadeTransition fadeOut(final Duration duration, final Node node) 
    {
        final FadeTransition fadeOut = new FadeTransition(duration, node);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent args) 
            {
                node.setVisible(false);
            }
        });
        return fadeOut;
    }  
}