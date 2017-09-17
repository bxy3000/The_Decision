package cn.zp.the_decision.Bean;

/**
 * Created by bxy3000 on 2017/9/13/0013.
 */

public class OptionItem {
    /**
     * 选项名称
     */
    private String optionName;
    /**
     * 选项比重(倾向程度)
     */
    private int weightLevel;

    public OptionItem() {
    }

    public OptionItem(String optionName) {
        this.optionName = optionName;
    }

    public OptionItem(int weightLevel) {
        this.weightLevel = weightLevel;
    }

    public OptionItem(String optionName, int weightLevel) {
        this.optionName = optionName;
        this.weightLevel = weightLevel;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getWeightLevel() {
        return weightLevel;
    }

    public void setWeightLevel(int weightLevel) {
        this.weightLevel = weightLevel;
    }
}
