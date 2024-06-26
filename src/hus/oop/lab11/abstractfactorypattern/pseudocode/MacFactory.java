package hus.oop.lab11.abstractfactorypattern.pseudocode;

public class MacFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new MacButton();
    }
    @Override
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}
