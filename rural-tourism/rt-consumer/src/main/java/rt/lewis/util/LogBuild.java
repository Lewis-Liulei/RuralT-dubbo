package rt.lewis.util;

public class LogBuild
{
  private static final String DEFAULT_PARAM_VALUE_SPLITTER = "=";
  private static final String DEFAULT_PARAM_SPLITTER = ", ";
  private static final String DEFAULT_LOG_SPLITTER = " - ";

  public static Builder getBuilder(String flag, String step)
  {
    return new Builder(flag, step, null, null);
  }

  public static Builder getBuilder(String flag, String step, String key, String value)
  {
    return new Builder(flag, step, key, value);
  }

  public static class Builder
  {
    private String flag;
    private String step;
    private String key;
    private String value;
    private StringBuilder params;

    private String getFlag()
    {
      return this.flag;
    }
    private void setFlag(String flag) {
      this.flag = flag;
    }
    private String getStep() {
      return this.step;
    }
    private void setStep(String step) {
      this.step = step;
    }
    private String getKey() {
      return this.key;
    }
    private void setKey(String key) {
      this.key = key;
    }
    private String getValue() {
      return this.value;
    }
    private void setValue(String value) {
      this.value = value;
    }
    private StringBuilder getParams() {
      return this.params;
    }
    private void setParams(StringBuilder params) {
      this.params = params;
    }
    private Builder() {
    }

    public Builder(String flag, String step, String key, String value) {
      setFlag(flag);
      setStep(step);
      setKey(key);
      setValue(value);
      setParams(new StringBuilder());
    }

    public Builder flag(String flag) {
      setFlag(flag);
      return this;
    }

    public Builder step(String step) {
      setStep(step);
      return this;
    }

    public Builder kv(String key, String value) {
      setKey(key);
      setValue(value);
      return this;
    }

    public Builder appendPV(String param, String value) {
      if (getParams() == null) {
        setParams(new StringBuilder());
      }
      if (getParams().length() > 0) {
        getParams().append(", ");
      }
      getParams().append(param).append("=").append(value);
      return this;
    }

    public Builder appendPV(String param, boolean value)
    {
      return appendPV(param, String.valueOf(value));
    }

    public Builder appendPV(String param, int value) {
      return appendPV(param, String.valueOf(value));
    }

    public Builder appendPV(String param, Integer value) {
      return appendPV(param, String.valueOf(value));
    }

    public Builder appendPV(String param, long value) {
      return appendPV(param, String.valueOf(value));
    }

    public Builder appendPV(String param, Long value) {
      return appendPV(param, String.valueOf(value));
    }

    public Builder appendPV(String param, float value) {
      return appendPV(param, String.valueOf(value));
    }

    public Builder appendPV(String param, double value) {
      return appendPV(param, String.valueOf(value));
    }

    public String build() {
      return toString();
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder().append(getFlag())
        .append(" - ").append(getStep())
        .append(" - ").append(getKey()).append("=").append(getValue());
      if ((getParams() != null) && (getParams().length() > 0)) {
        sb.append(", ").append(getParams());
      }
      return sb.toString();
    }
  }
}
