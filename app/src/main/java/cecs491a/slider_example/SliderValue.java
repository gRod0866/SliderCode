package cecs491a.slider_example;

public class SliderValue {
    int max, min;

    public SliderValue(int min, int max){
        this.max = max;
        this.min = min;
    }

    public SliderValue(int min) {
        this.min = min;
        this.max = min;
    }
}