package  com.rookie.shared.domain;

import java.util.Objects;

public abstract class IntValueObject {
    private Integer value;

    protected IntValueObject(Integer value) {
        this.value = value;
    }
    protected IntValueObject() {}
    
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntValueObject that = (IntValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    

}
