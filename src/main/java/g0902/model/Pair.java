package g0902.model;

import java.util.Objects;

public class Pair<L,R> {
    private L l;
    private R r;
    public Pair(L l, R r){
        this.l = l;
        this.r = r;
    }
    public L getL(){ return l; }
    public R getR(){ return r; }
    public void setL(L l){ this.l = l; }
    public void setR(R r){ this.r = r; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?, ?> pair)) return false;
        return Objects.equals(getL(), pair.getL()) && Objects.equals(getR(), pair.getR());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getL(), getR());
    }
}