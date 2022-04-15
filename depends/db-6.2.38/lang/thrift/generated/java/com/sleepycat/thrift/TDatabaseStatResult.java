/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sleepycat.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-01-23")
public class TDatabaseStatResult implements org.apache.thrift.TBase<TDatabaseStatResult, TDatabaseStatResult._Fields>, java.io.Serializable, Cloneable, Comparable<TDatabaseStatResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDatabaseStatResult");

  private static final org.apache.thrift.protocol.TField BTREE_STAT_FIELD_DESC = new org.apache.thrift.protocol.TField("btreeStat", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField HASH_STAT_FIELD_DESC = new org.apache.thrift.protocol.TField("hashStat", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField HEAP_STAT_FIELD_DESC = new org.apache.thrift.protocol.TField("heapStat", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField QUEUE_STAT_FIELD_DESC = new org.apache.thrift.protocol.TField("queueStat", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TDatabaseStatResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TDatabaseStatResultTupleSchemeFactory();

  public TBtreeStat btreeStat; // optional
  public THashStat hashStat; // optional
  public THeapStat heapStat; // optional
  public TQueueStat queueStat; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BTREE_STAT((short)1, "btreeStat"),
    HASH_STAT((short)2, "hashStat"),
    HEAP_STAT((short)3, "heapStat"),
    QUEUE_STAT((short)4, "queueStat");

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
        case 1: // BTREE_STAT
          return BTREE_STAT;
        case 2: // HASH_STAT
          return HASH_STAT;
        case 3: // HEAP_STAT
          return HEAP_STAT;
        case 4: // QUEUE_STAT
          return QUEUE_STAT;
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
  private static final _Fields optionals[] = {_Fields.BTREE_STAT,_Fields.HASH_STAT,_Fields.HEAP_STAT,_Fields.QUEUE_STAT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BTREE_STAT, new org.apache.thrift.meta_data.FieldMetaData("btreeStat", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TBtreeStat.class)));
    tmpMap.put(_Fields.HASH_STAT, new org.apache.thrift.meta_data.FieldMetaData("hashStat", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, THashStat.class)));
    tmpMap.put(_Fields.HEAP_STAT, new org.apache.thrift.meta_data.FieldMetaData("heapStat", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, THeapStat.class)));
    tmpMap.put(_Fields.QUEUE_STAT, new org.apache.thrift.meta_data.FieldMetaData("queueStat", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TQueueStat.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDatabaseStatResult.class, metaDataMap);
  }

  public TDatabaseStatResult() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDatabaseStatResult(TDatabaseStatResult other) {
    if (other.isSetBtreeStat()) {
      this.btreeStat = new TBtreeStat(other.btreeStat);
    }
    if (other.isSetHashStat()) {
      this.hashStat = new THashStat(other.hashStat);
    }
    if (other.isSetHeapStat()) {
      this.heapStat = new THeapStat(other.heapStat);
    }
    if (other.isSetQueueStat()) {
      this.queueStat = new TQueueStat(other.queueStat);
    }
  }

  public TDatabaseStatResult deepCopy() {
    return new TDatabaseStatResult(this);
  }

  @Override
  public void clear() {
    this.btreeStat = null;
    this.hashStat = null;
    this.heapStat = null;
    this.queueStat = null;
  }

  public TBtreeStat getBtreeStat() {
    return this.btreeStat;
  }

  public TDatabaseStatResult setBtreeStat(TBtreeStat btreeStat) {
    this.btreeStat = btreeStat;
    return this;
  }

  public void unsetBtreeStat() {
    this.btreeStat = null;
  }

  /** Returns true if field btreeStat is set (has been assigned a value) and false otherwise */
  public boolean isSetBtreeStat() {
    return this.btreeStat != null;
  }

  public void setBtreeStatIsSet(boolean value) {
    if (!value) {
      this.btreeStat = null;
    }
  }

  public THashStat getHashStat() {
    return this.hashStat;
  }

  public TDatabaseStatResult setHashStat(THashStat hashStat) {
    this.hashStat = hashStat;
    return this;
  }

  public void unsetHashStat() {
    this.hashStat = null;
  }

  /** Returns true if field hashStat is set (has been assigned a value) and false otherwise */
  public boolean isSetHashStat() {
    return this.hashStat != null;
  }

  public void setHashStatIsSet(boolean value) {
    if (!value) {
      this.hashStat = null;
    }
  }

  public THeapStat getHeapStat() {
    return this.heapStat;
  }

  public TDatabaseStatResult setHeapStat(THeapStat heapStat) {
    this.heapStat = heapStat;
    return this;
  }

  public void unsetHeapStat() {
    this.heapStat = null;
  }

  /** Returns true if field heapStat is set (has been assigned a value) and false otherwise */
  public boolean isSetHeapStat() {
    return this.heapStat != null;
  }

  public void setHeapStatIsSet(boolean value) {
    if (!value) {
      this.heapStat = null;
    }
  }

  public TQueueStat getQueueStat() {
    return this.queueStat;
  }

  public TDatabaseStatResult setQueueStat(TQueueStat queueStat) {
    this.queueStat = queueStat;
    return this;
  }

  public void unsetQueueStat() {
    this.queueStat = null;
  }

  /** Returns true if field queueStat is set (has been assigned a value) and false otherwise */
  public boolean isSetQueueStat() {
    return this.queueStat != null;
  }

  public void setQueueStatIsSet(boolean value) {
    if (!value) {
      this.queueStat = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case BTREE_STAT:
      if (value == null) {
        unsetBtreeStat();
      } else {
        setBtreeStat((TBtreeStat)value);
      }
      break;

    case HASH_STAT:
      if (value == null) {
        unsetHashStat();
      } else {
        setHashStat((THashStat)value);
      }
      break;

    case HEAP_STAT:
      if (value == null) {
        unsetHeapStat();
      } else {
        setHeapStat((THeapStat)value);
      }
      break;

    case QUEUE_STAT:
      if (value == null) {
        unsetQueueStat();
      } else {
        setQueueStat((TQueueStat)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BTREE_STAT:
      return getBtreeStat();

    case HASH_STAT:
      return getHashStat();

    case HEAP_STAT:
      return getHeapStat();

    case QUEUE_STAT:
      return getQueueStat();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case BTREE_STAT:
      return isSetBtreeStat();
    case HASH_STAT:
      return isSetHashStat();
    case HEAP_STAT:
      return isSetHeapStat();
    case QUEUE_STAT:
      return isSetQueueStat();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TDatabaseStatResult)
      return this.equals((TDatabaseStatResult)that);
    return false;
  }

  public boolean equals(TDatabaseStatResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_btreeStat = true && this.isSetBtreeStat();
    boolean that_present_btreeStat = true && that.isSetBtreeStat();
    if (this_present_btreeStat || that_present_btreeStat) {
      if (!(this_present_btreeStat && that_present_btreeStat))
        return false;
      if (!this.btreeStat.equals(that.btreeStat))
        return false;
    }

    boolean this_present_hashStat = true && this.isSetHashStat();
    boolean that_present_hashStat = true && that.isSetHashStat();
    if (this_present_hashStat || that_present_hashStat) {
      if (!(this_present_hashStat && that_present_hashStat))
        return false;
      if (!this.hashStat.equals(that.hashStat))
        return false;
    }

    boolean this_present_heapStat = true && this.isSetHeapStat();
    boolean that_present_heapStat = true && that.isSetHeapStat();
    if (this_present_heapStat || that_present_heapStat) {
      if (!(this_present_heapStat && that_present_heapStat))
        return false;
      if (!this.heapStat.equals(that.heapStat))
        return false;
    }

    boolean this_present_queueStat = true && this.isSetQueueStat();
    boolean that_present_queueStat = true && that.isSetQueueStat();
    if (this_present_queueStat || that_present_queueStat) {
      if (!(this_present_queueStat && that_present_queueStat))
        return false;
      if (!this.queueStat.equals(that.queueStat))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetBtreeStat()) ? 131071 : 524287);
    if (isSetBtreeStat())
      hashCode = hashCode * 8191 + btreeStat.hashCode();

    hashCode = hashCode * 8191 + ((isSetHashStat()) ? 131071 : 524287);
    if (isSetHashStat())
      hashCode = hashCode * 8191 + hashStat.hashCode();

    hashCode = hashCode * 8191 + ((isSetHeapStat()) ? 131071 : 524287);
    if (isSetHeapStat())
      hashCode = hashCode * 8191 + heapStat.hashCode();

    hashCode = hashCode * 8191 + ((isSetQueueStat()) ? 131071 : 524287);
    if (isSetQueueStat())
      hashCode = hashCode * 8191 + queueStat.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TDatabaseStatResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetBtreeStat()).compareTo(other.isSetBtreeStat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBtreeStat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.btreeStat, other.btreeStat);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetHashStat()).compareTo(other.isSetHashStat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHashStat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hashStat, other.hashStat);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetHeapStat()).compareTo(other.isSetHeapStat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHeapStat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.heapStat, other.heapStat);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetQueueStat()).compareTo(other.isSetQueueStat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueueStat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queueStat, other.queueStat);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TDatabaseStatResult(");
    boolean first = true;

    if (isSetBtreeStat()) {
      sb.append("btreeStat:");
      if (this.btreeStat == null) {
        sb.append("null");
      } else {
        sb.append(this.btreeStat);
      }
      first = false;
    }
    if (isSetHashStat()) {
      if (!first) sb.append(", ");
      sb.append("hashStat:");
      if (this.hashStat == null) {
        sb.append("null");
      } else {
        sb.append(this.hashStat);
      }
      first = false;
    }
    if (isSetHeapStat()) {
      if (!first) sb.append(", ");
      sb.append("heapStat:");
      if (this.heapStat == null) {
        sb.append("null");
      } else {
        sb.append(this.heapStat);
      }
      first = false;
    }
    if (isSetQueueStat()) {
      if (!first) sb.append(", ");
      sb.append("queueStat:");
      if (this.queueStat == null) {
        sb.append("null");
      } else {
        sb.append(this.queueStat);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (btreeStat != null) {
      btreeStat.validate();
    }
    if (hashStat != null) {
      hashStat.validate();
    }
    if (heapStat != null) {
      heapStat.validate();
    }
    if (queueStat != null) {
      queueStat.validate();
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

  private static class TDatabaseStatResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TDatabaseStatResultStandardScheme getScheme() {
      return new TDatabaseStatResultStandardScheme();
    }
  }

  private static class TDatabaseStatResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TDatabaseStatResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDatabaseStatResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BTREE_STAT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.btreeStat = new TBtreeStat();
              struct.btreeStat.read(iprot);
              struct.setBtreeStatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HASH_STAT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.hashStat = new THashStat();
              struct.hashStat.read(iprot);
              struct.setHashStatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HEAP_STAT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.heapStat = new THeapStat();
              struct.heapStat.read(iprot);
              struct.setHeapStatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // QUEUE_STAT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.queueStat = new TQueueStat();
              struct.queueStat.read(iprot);
              struct.setQueueStatIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDatabaseStatResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.btreeStat != null) {
        if (struct.isSetBtreeStat()) {
          oprot.writeFieldBegin(BTREE_STAT_FIELD_DESC);
          struct.btreeStat.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.hashStat != null) {
        if (struct.isSetHashStat()) {
          oprot.writeFieldBegin(HASH_STAT_FIELD_DESC);
          struct.hashStat.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.heapStat != null) {
        if (struct.isSetHeapStat()) {
          oprot.writeFieldBegin(HEAP_STAT_FIELD_DESC);
          struct.heapStat.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.queueStat != null) {
        if (struct.isSetQueueStat()) {
          oprot.writeFieldBegin(QUEUE_STAT_FIELD_DESC);
          struct.queueStat.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDatabaseStatResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TDatabaseStatResultTupleScheme getScheme() {
      return new TDatabaseStatResultTupleScheme();
    }
  }

  private static class TDatabaseStatResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TDatabaseStatResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDatabaseStatResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetBtreeStat()) {
        optionals.set(0);
      }
      if (struct.isSetHashStat()) {
        optionals.set(1);
      }
      if (struct.isSetHeapStat()) {
        optionals.set(2);
      }
      if (struct.isSetQueueStat()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetBtreeStat()) {
        struct.btreeStat.write(oprot);
      }
      if (struct.isSetHashStat()) {
        struct.hashStat.write(oprot);
      }
      if (struct.isSetHeapStat()) {
        struct.heapStat.write(oprot);
      }
      if (struct.isSetQueueStat()) {
        struct.queueStat.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDatabaseStatResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.btreeStat = new TBtreeStat();
        struct.btreeStat.read(iprot);
        struct.setBtreeStatIsSet(true);
      }
      if (incoming.get(1)) {
        struct.hashStat = new THashStat();
        struct.hashStat.read(iprot);
        struct.setHashStatIsSet(true);
      }
      if (incoming.get(2)) {
        struct.heapStat = new THeapStat();
        struct.heapStat.read(iprot);
        struct.setHeapStatIsSet(true);
      }
      if (incoming.get(3)) {
        struct.queueStat = new TQueueStat();
        struct.queueStat.read(iprot);
        struct.setQueueStatIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

