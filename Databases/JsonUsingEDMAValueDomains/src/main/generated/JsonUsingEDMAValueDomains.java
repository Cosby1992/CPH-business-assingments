package main.generated;

import java.util.ArrayList;
import java.util.Collection;
import org.abstractica.edma.metamodel.IMetaEnvironment;
import org.abstractica.edma.metamodel.impl.MetaEnvironment;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder.Field;
import org.abstractica.edma.runtime.implementations.mem.modelstore.speed.newindex.IndexUtil;
import org.abstractica.edma.runtime.intf.IRuntimeFactory;
import org.abstractica.edma.valuedomains.impl.Constraint;

/**
 * 
 */
public class JsonUsingEDMAValueDomains
{
    public static final IMetaEnvironment environment = generateEnvironment();



    /**
     * generate the environment
     * @return  
     */
    public static IMetaEnvironment generateEnvironment()
    {
        ValueDomainBuilder vdb = new ValueDomainBuilder();
        
        //String value domain: AnyString
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("AnyString", null, null, null, null, edma_constraints, false);
        }
        
        //Boolean value domain: AnyBool
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newBooleanDomain("AnyBool", null, edma_constraints, false);
        }
        
        //Integer value domain: AnyInt
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("AnyInt", null, null, null, edma_constraints, false);
        }
        
        //Float value domain: AnyFloat
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newFloatDomain("AnyFloat", null, null, null, edma_constraints, false);
        }
        
        //String value domain: Key
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("Key", null, 1, null, null, edma_constraints, false);
        }
        
        //OneOf value domain: Value
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<String> optionDomains = new ArrayList<String>(6);
            optionDomains.add("AnyString");
            optionDomains.add("AnyBool");
            optionDomains.add("AnyInt");
            optionDomains.add("AnyFloat");
            optionDomains.add("AnyArray");
            optionDomains.add("JsonObject");
            vdb.newOneOfDomain("Value", null, optionDomains, edma_constraints, false);
        }
        
        //Struct value domain: Member
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("pair", "Pair", false));
            fields.add(vdb.newStructField("member", "Member", true));
            vdb.newStructDomain("Member", null, fields, edma_constraints, false);
        }
        
        //List value domain: AnyArray
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newListDomain("AnyArray", null, "Value", null, null, edma_constraints, false);
        }
        
        //Struct value domain: Pair
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("key", "Key", false));
            fields.add(vdb.newStructField("value", "Value", false));
            vdb.newStructDomain("Pair", null, fields, edma_constraints, false);
        }
        
        //Struct value domain: JsonObject
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("member", "Member", false));
            vdb.newStructDomain("JsonObject", null, fields, edma_constraints, false);
        }
        MetaEnvironment edma_environment = new MetaEnvironment("JsonUsingEDMAValueDomains");
        vdb.buildWithEnvironment(edma_environment);
        //Hack to make serializeable work...
        IndexUtil.setValueDomainDefinitions(edma_environment.getValueDomainDefinitions());
        return edma_environment;
    }

    /**
     * Constructor
     * @param factory  The runtime factory
     */
    public JsonUsingEDMAValueDomains(IRuntimeFactory factory)
    {
        
    }
}
