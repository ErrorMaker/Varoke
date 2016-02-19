/*
 * Decompiled with CFR 0_110.
 */
package ch.rootkit.varoke.habbohotel.pathfinding;

public abstract class AbstractNode {
    protected static final int BASICMOVEMENTCOST = 10;
    protected static final int DIAGONALMOVEMENTCOST = 14;
    private int xPosition;
    private int yPosition;
    private boolean walkable;
    private AbstractNode previous;
    private boolean diagonally;
    private int movementPanelty;
    private int gCosts;
    private int hCosts;

    AbstractNode(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.walkable = true;
        this.movementPanelty = 0;
    }

    public boolean isDiagonaly() {
        return this.diagonally;
    }

    public void setIsDiagonaly(boolean isDiagonaly) {
        this.diagonally = isDiagonaly;
    }

    public void setCoordinates(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getX() {
        return this.xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public boolean isWalkable() {
        return this.walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public AbstractNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(AbstractNode previous) {
        this.previous = previous;
    }

    public void setMovementPanelty(int movementPanelty) {
        this.movementPanelty = movementPanelty;
    }

    public int getfCosts() {
        return this.gCosts + this.hCosts;
    }

    public int getgCosts() {
        return this.gCosts;
    }

    private void setgCosts(int gCosts) {
        this.gCosts = gCosts + this.movementPanelty;
    }

    void setgCosts(AbstractNode previousAbstractNode, int basicCost) {
        this.setgCosts(previousAbstractNode.getgCosts() + basicCost);
    }

    public void setgCosts(AbstractNode previousAbstractNode) {
        if (this.diagonally) {
            this.setgCosts(previousAbstractNode, 14);
        } else {
            this.setgCosts(previousAbstractNode, 10);
        }
    }

    public int calculategCosts(AbstractNode previousAbstractNode) {
        if (this.diagonally) {
            return previousAbstractNode.getgCosts() + 14 + this.movementPanelty;
        }
        return previousAbstractNode.getgCosts() + 10 + this.movementPanelty;
    }

    public int calculategCosts(AbstractNode previousAbstractNode, int movementCost) {
        return previousAbstractNode.getgCosts() + movementCost + this.movementPanelty;
    }

    int gethCosts() {
        return this.hCosts;
    }

    void sethCosts(int hCosts) {
        this.hCosts = hCosts;
    }

    public abstract void sethCosts(AbstractNode var1);

    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + "): h: " + this.gethCosts() + " g: " + this.getgCosts() + " f: " + this.getfCosts();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        AbstractNode other = (AbstractNode)obj;
        return this.xPosition == other.xPosition && this.yPosition == other.yPosition;
    }

    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.xPosition;
        hash = 17 * hash + this.yPosition;
        return hash;
    }
}

