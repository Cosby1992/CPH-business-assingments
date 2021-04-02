package main.generated.valuedomains.external;

import org.abstractica.edma.util.Pair;
import org.abstractica.edma.valuedomains.IExternalConstraints;

/**
 * 
 */
public class EDMA_ExternalConstraints implements IExternalConstraints
{
    public static final IExternalConstraints instance = new EDMA_ExternalConstraints();



    /**
     * Constructor
     */
    public EDMA_ExternalConstraints()
    {
        
    }

    /**
     * check external constraints
     * @param edma_obj    The value object to check
     * @param edma_index  Value domain index
     * @return            A pair of the index of the first constraint that is
     *                    violated and the error message or <tt>null</tt> if no
     *                    constraints are violated
     */
    public Pair<Integer, String> checkConstraints(Object edma_obj, int edma_index)
    {
        switch(edma_index)
        {
            default :
                throw new RuntimeException("Internal Error!");
        }
    }
}
