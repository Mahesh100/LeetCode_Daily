class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        nextVal = iter.hasNext() ? iter.next() : null;
    }

    public Integer peek() {
        return nextVal;
    }

    @Override
    public Integer next() {
        Integer oldNext = nextVal;
        nextVal = iter.hasNext() ? iter.next() : null;
        return oldNext; 
    }

    @Override
    public boolean hasNext() {
        return (nextVal != null);
    }
}