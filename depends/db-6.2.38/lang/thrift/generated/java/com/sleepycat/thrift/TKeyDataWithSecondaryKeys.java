/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sleepycat.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-01-23")
public class TKeyDataWithSecondaryKeys implements org.apache.thrift.TBase<TKeyDataWithSecondaryKeys, TKeyDataWithSecondaryKeys._Fields>, java.io.Serializable, Cloneable, Comparable<TKeyDataWithSecondaryKeys> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TKeyDataWithSecondaryKeys");

  private static final org.apache.thrift.protocol.TField PKEY_FIELD_DESC = new org.apache.thrift.protocol.TField("pkey", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PDATA_FIELD_DESC = new org.apache.thrift.protocol.TField("pdata", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField SKEYS_FIELD_DESC = new org.apache.thrift.protocol.TField("skeys", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TKeyDataWithSecondaryKeysStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TKeyDataWithSecondaryKeysTupleSchemeFactory();

  public TDbt pkey; // optional
  public TDbt pdata; // optional
  public java.util.Map<TDatabase,java.util.List<TDbt>> skeys; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PKEY((short)1, "pkey"),
    PDATA((short)2, "pdata"),
    SKEYS((short)3, "skeys");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PKEY
          return PKEY;
        case 2: // PDATA
          return PDATA;
        case 3: // SKEYS
          return SKEYS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.PKEY,_Fields.PDATA,_Fields.SKEYS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PKEY, new org.apache.thrift.meta_data.FieldMetaData("pkey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TDbt.class)));
    tmpMap.put(_Fields.PDATA, new org.apache.thrift.meta_data.FieldMetaData("pdata", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TDbt.class)));
    tmpMap.put(_Fields.SKEYS, new org.apache.thrift.meta_data.FieldMetaData("skeys", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TDatabase.class), 
            new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TDbt.class)))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TKeyDataWithSecondaryKeys.class, metaDataMap);
  }

  public TKeyDataWithSecondaryKeys() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TKeyDataWithSecondaryKeys(TKeyDataWithSecondaryKeys other) {
    if (other.isSetPkey()) {
      this.pkey = new TDbt(other.pkey);
    }
    if (other.isSetPdata()) {
      this.pdata = new TDbt(other.pdata);
    }
    if (other.isSetSkeys()) {
      java.util.Map<TDatabase,java.util.List<TDbt>> __this__skeys = new java.util.HashMap<TDatabase,java.util.List<TDbt>>(other.skeys.size());
      for (java.util.Map.Entry<TDatabase, java.util.List<TDbt>> other_element : other.skeys.entrySet()) {

        TDatabase other_element_key = other_element.getKey();
        java.util.List<TDbt> other_element_value = other_element.getValue();

        TDatabase __this__skeys_copy_key = new TDatabase(other_element_key);

        java.util.List<TDbt> __this__skeys_copy_value = new java.util.ArrayList<TDbt>(other_element_value.size());
        for (TDbt other_element_value_element : other_element_value) {
          __this__skeys_copy_value.add(new TDbt(other_element_value_element));
        }

        __this__skeys.put(__this__skeys_copy_key, __this__skeys_copy_value);
      }
      this.skeys = __this__skeys;
    }
  }

  public TKeyDataWithSecondaryKeys deepCopy() {
    return new TKeyDataWithSecondaryKeys(this);
  }

  @Override
  public void clear() {
    this.pkey = null;
    this.pdata = null;
    this.skeys = null;
  }

  public TDbt getPkey() {
    return this.pkey;
  }

  public TKeyDataWithSecondaryKeys setPkey(TDbt pkey) {
    this.pkey = pkey;
    return this;
  }

  public void unsetPkey() {
    this.pkey = null;
  }

  /** Returns true if field pkey is set (has been assigned a value) and false otherwise */
  public boolean isSetPkey() {
    return this.pkey != null;
  }

  public void setPkeyIsSet(boolean value) {
    if (!value) {
      this.pkey = null;
    }
  }

  public TDbt getPdata() {
    return this.pdata;
  }

  public TKeyDataWithSecondaryKeys setPdata(TDbt pdata) {
    this.pdata = pdata;
    return this;
  }

  public void unsetPdata() {
    this.pdata = null;
  }

  /** Returns true if field pdata is set (has been assigned a value) and false otherwise */
  public boolean isSetPdata() {
    return this.pdata != null;
  }

  public void setPdataIsSet(boolean value) {
    if (!value) {
      this.pdata = null;
    }
  }

  public int getSkeysSize() {
    return (this.skeys == null) ? 0 : this.skeys.size();
  }

  public void putToSkeys(TDatabase key, java.util.List<TDbt> val) {
    if (this.skeys == null) {
      this.skeys = new java.util.HashMap<TDatabase,java.util.List<TDbt>>();
    }
    this.skeys.put(key, val);
  }

  public java.util.Map<TDatabase,java.util.List<TDbt>> getSkeys() {
    return this.skeys;
  }

  public TKeyDataWithSecondaryKeys setSkeys(java.util.Map<TDatabase,java.util.List<TDbt>> skeys) {
    this.skeys = skeys;
    return this;
  }

  public void unsetSkeys() {
    this.skeys = null;
  }

  /** Returns true if field skeys is set (has been assigned a value) and false otherwise */
  public boolean isSetSkeys() {
    return this.skeys != null;
  }

  public void setSkeysIsSet(boolean value) {
    if (!value) {
      this.skeys = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case PKEY:
      if (value == null) {
        unsetPkey();
      } else {
        setPkey((TDbt)value);
      }
      break;

    case PDATA:
      if (value == null) {
        unsetPdata();
      } else {
        setPdata((TDbt)value);
      }
      break;

    case SKEYS:
      if (value == null) {
        unsetSkeys();
      } else {
        setSkeys((java.util.Map<TDatabase,java.util.List<TDbt>>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PKEY:
      return getPkey();

    case PDATA:
      return getPdata();

    case SKEYS:
      return getSkeys();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PKEY:
      return isSetPkey();
    case PDATA:
      return isSetPdata();
    case SKEYS:
      return isSetSkeys();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TKeyDataWithSecondaryKeys)
      return this.equals((TKeyDataWithSecondaryKeys)that);
    return false;
  }

  public boolean equals(TKeyDataWithSecondaryKeys that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_pkey = true && this.isSetPkey();
    boolean that_present_pkey = true && that.isSetPkey();
    if (this_present_pkey || that_present_pkey) {
      if (!(this_present_pkey && that_present_pkey))
        return false;
      if (!this.pkey.equals(that.pkey))
        return false;
    }

    boolean this_present_pdata = true && this.isSetPdata();
    boolean that_present_pdata = true && that.isSetPdata();
    if (this_present_pdata || that_present_pdata) {
      if (!(this_present_pdata && that_present_pdata))
        return false;
      if (!this.pdata.equals(that.pdata))
        return false;
    }

    boolean this_present_skeys = true && this.isSetSkeys();
    boolean that_present_skeys = true && that.isSetSkeys();
    if (this_present_skeys || that_present_skeys) {
      if (!(this_present_skeys && that_present_skeys))
        return false;
      if (!this.skeys.equals(that.skeys))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPkey()) ? 131071 : 524287);
    if (isSetPkey())
      hashCode = hashCode * 8191 + pkey.hashCode();

    hashCode = hashCode * 8191 + ((isSetPdata()) ? 131071 : 524287);
    if (isSetPdata())
      hashCode = hashCode * 8191 + pdata.hashCode();

    hashCode = hashCode * 8191 + ((isSetSkeys()) ? 131071 : 524287);
    if (isSetSkeys())
      hashCode = hashCode * 8191 + skeys.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TKeyDataWithSecondaryKeys other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetPkey()).compareTo(other.isSetPkey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPkey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pkey, other.pkey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPdata()).compareTo(other.isSetPdata());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPdata()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pdata, other.pdata);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSkeys()).compareTo(other.isSetSkeys());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSkeys()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.skeys, other.skeys);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TKeyDataWithSecondaryKeys(");
    boolean first = true;

    if (isSetPkey()) {
      sb.append("pkey:");
      if (this.pkey == null) {
        sb.append("null");
      } else {
        sb.append(this.pkey);
      }
      first = false;
    }
    if (isSetPdata()) {
      if (!first) sb.append(", ");
      sb.append("pdata:");
      if (this.pdata == null) {
        sb.append("null");
      } else {
        sb.append(this.pdata);
      }
      first = false;
    }
    if (isSetSkeys()) {
      if (!first) sb.append(", ");
      sb.append("skeys:");
      if (this.skeys == null) {
        sb.append("null");
      } else {
        sb.append(this.skeys);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (pkey != null) {
      pkey.validate();
    }
    if (pdata != null) {
      pdata.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TKeyDataWithSecondaryKeysStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TKeyDataWithSecondaryKeysStandardScheme getScheme() {
      return new TKeyDataWithSecondaryKeysStandardScheme();
    }
  }

  private static class TKeyDataWithSecondaryKeysStandardScheme extends org.apache.thrift.scheme.StandardScheme<TKeyDataWithSecondaryKeys> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TKeyDataWithSecondaryKeys struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PKEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.pkey = new TDbt();
              struct.pkey.read(iprot);
              struct.setPkeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PDATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.pdata = new TDbt();
              struct.pdata.read(iprot);
              struct.setPdataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SKEYS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.skeys = new java.util.HashMap<TDatabase,java.util.List<TDbt>>(2*_map0.size);
                TDatabase _key1;
                java.util.List<TDbt> _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = new TDatabase();
                  _key1.read(iprot);
                  {
                    org.apache.thrift.protocol.TList _list4 = iprot.readListBegin();
                    _val2 = new java.util.ArrayList<TDbt>(_list4.size);
                    TDbt _elem5;
                    for (int _i6 = 0; _i6 < _list4.size; ++_i6)
                    {
                      _elem5 = new TDbt();
                      _elem5.read(iprot);
                      _val2.add(_elem5);
                    }
                    iprot.readListEnd();
                  }
                  struct.skeys.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setSkeysIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TKeyDataWithSecondaryKeys struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.pkey != null) {
        if (struct.isSetPkey()) {
          oprot.writeFieldBegin(PKEY_FIELD_DESC);
          struct.pkey.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.pdata != null) {
        if (struct.isSetPdata()) {
          oprot.writeFieldBegin(PDATA_FIELD_DESC);
          struct.pdata.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.skeys != null) {
        if (struct.isSetSkeys()) {
          oprot.writeFieldBegin(SKEYS_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRUCT, org.apache.thrift.protocol.TType.LIST, struct.skeys.size()));
            for (java.util.Map.Entry<TDatabase, java.util.List<TDbt>> _iter7 : struct.skeys.entrySet())
            {
              _iter7.getKey().write(oprot);
              {
                oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter7.getValue().size()));
                for (TDbt _iter8 : _iter7.getValue())
                {
                  _iter8.write(oprot);
                }
                oprot.writeListEnd();
              }
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TKeyDataWithSecondaryKeysTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TKeyDataWithSecondaryKeysTupleScheme getScheme() {
      return new TKeyDataWithSecondaryKeysTupleScheme();
    }
  }

  private static class TKeyDataWithSecondaryKeysTupleScheme extends org.apache.thrift.scheme.TupleScheme<TKeyDataWithSecondaryKeys> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TKeyDataWithSecondaryKeys struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetPkey()) {
        optionals.set(0);
      }
      if (struct.isSetPdata()) {
        optionals.set(1);
      }
      if (struct.isSetSkeys()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetPkey()) {
        struct.pkey.write(oprot);
      }
      if (struct.isSetPdata()) {
        struct.pdata.write(oprot);
      }
      if (struct.isSetSkeys()) {
        {
          oprot.writeI32(struct.skeys.size());
          for (java.util.Map.Entry<TDatabase, java.util.List<TDbt>> _iter9 : struct.skeys.entrySet())
          {
            _iter9.getKey().write(oprot);
            {
              oprot.writeI32(_iter9.getValue().size());
              for (TDbt _iter10 : _iter9.getValue())
              {
                _iter10.write(oprot);
              }
            }
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TKeyDataWithSecondaryKeys struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.pkey = new TDbt();
        struct.pkey.read(iprot);
        struct.setPkeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pdata = new TDbt();
        struct.pdata.read(iprot);
        struct.setPdataIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map11 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRUCT, org.apache.thrift.protocol.TType.LIST, iprot.readI32());
          struct.skeys = new java.util.HashMap<TDatabase,java.util.List<TDbt>>(2*_map11.size);
          TDatabase _key12;
          java.util.List<TDbt> _val13;
          for (int _i14 = 0; _i14 < _map11.size; ++_i14)
          {
            _key12 = new TDatabase();
            _key12.read(iprot);
            {
              org.apache.thrift.protocol.TList _list15 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
              _val13 = new java.util.ArrayList<TDbt>(_list15.size);
              TDbt _elem16;
              for (int _i17 = 0; _i17 < _list15.size; ++_i17)
              {
                _elem16 = new TDbt();
                _elem16.read(iprot);
                _val13.add(_elem16);
              }
            }
            struct.skeys.put(_key12, _val13);
          }
        }
        struct.setSkeysIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

