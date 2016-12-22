package network.pipeline.header;

/**
 * Created by Sebastían on 21/12/2016.
 */
public class ApiRevision {

    /**
     * Represents the Api revision
     */
    private final int revision;

    /**
     * Constructs the Api revision based on a revision
     * @param revision  the reision
     */
    public ApiRevision(final int revision) {
        this.revision = revision;
    }

    /**
     * Gets the revision of the api
     * @return  the revision
     */
    public int getRevision() {
        return revision;
    }
}
