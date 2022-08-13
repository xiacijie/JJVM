package org.jjvm.instruction;

import org.jjvm.exception.JJException;
import org.jjvm.instruction.add.DADD;
import org.jjvm.instruction.add.FADD;
import org.jjvm.instruction.add.IADD;
import org.jjvm.instruction.add.LADD;
import org.jjvm.instruction.and.IAND;
import org.jjvm.instruction.and.LAND;
import org.jjvm.instruction.branch.GO_TO;
import org.jjvm.instruction.branch.IF_ACMPEQ;
import org.jjvm.instruction.branch.IF_ACMPNE;
import org.jjvm.instruction.branch.IF_EQ;
import org.jjvm.instruction.branch.IF_GE;
import org.jjvm.instruction.branch.IF_GT;
import org.jjvm.instruction.branch.IF_ICMPEQ;
import org.jjvm.instruction.branch.IF_ICMPGE;
import org.jjvm.instruction.branch.IF_ICMPGT;
import org.jjvm.instruction.branch.IF_ICMPLE;
import org.jjvm.instruction.branch.IF_ICMPLT;
import org.jjvm.instruction.branch.IF_ICMPNE;
import org.jjvm.instruction.branch.IF_LE;
import org.jjvm.instruction.branch.IF_LT;
import org.jjvm.instruction.branch.IF_NE;
import org.jjvm.instruction.branch.IF_NONNULL;
import org.jjvm.instruction.branch.IF_NULL;
import org.jjvm.instruction.branch.LOOKUP_SWITCH;
import org.jjvm.instruction.branch.TABLE_SWITCH;
import org.jjvm.instruction.comparison.DCMPG;
import org.jjvm.instruction.comparison.DCMPL;
import org.jjvm.instruction.comparison.FCMPG;
import org.jjvm.instruction.comparison.FCMPL;
import org.jjvm.instruction.comparison.LCMP;
import org.jjvm.instruction.constant.ACONST_NULL;
import org.jjvm.instruction.constant.BIPUSH;
import org.jjvm.instruction.constant.DCONST_0;
import org.jjvm.instruction.constant.DCONST_1;
import org.jjvm.instruction.constant.FCONST_0;
import org.jjvm.instruction.constant.FCONST_1;
import org.jjvm.instruction.constant.FCONST_2;
import org.jjvm.instruction.constant.ICONST_0;
import org.jjvm.instruction.constant.ICONST_1;
import org.jjvm.instruction.constant.ICONST_2;
import org.jjvm.instruction.constant.ICONST_3;
import org.jjvm.instruction.constant.ICONST_4;
import org.jjvm.instruction.constant.ICONST_5;
import org.jjvm.instruction.constant.ICONST_M1;
import org.jjvm.instruction.constant.LCONST_0;
import org.jjvm.instruction.constant.LCONST_1;
import org.jjvm.instruction.constant.NOP;
import org.jjvm.instruction.constant.SIPUSH;
import org.jjvm.instruction.conversion.D2F;
import org.jjvm.instruction.conversion.D2I;
import org.jjvm.instruction.conversion.D2L;
import org.jjvm.instruction.conversion.F2D;
import org.jjvm.instruction.conversion.F2I;
import org.jjvm.instruction.conversion.F2L;
import org.jjvm.instruction.conversion.I2B;
import org.jjvm.instruction.conversion.I2C;
import org.jjvm.instruction.conversion.I2D;
import org.jjvm.instruction.conversion.I2F;
import org.jjvm.instruction.conversion.I2L;
import org.jjvm.instruction.conversion.I2S;
import org.jjvm.instruction.conversion.L2D;
import org.jjvm.instruction.conversion.L2F;
import org.jjvm.instruction.conversion.L2I;
import org.jjvm.instruction.div.DDIV;
import org.jjvm.instruction.div.FDIV;
import org.jjvm.instruction.div.IDIV;
import org.jjvm.instruction.div.LDIV;
import org.jjvm.instruction.dup.DUP;
import org.jjvm.instruction.dup.DUP2;
import org.jjvm.instruction.dup.DUP2_X1;
import org.jjvm.instruction.dup.DUP2_X2;
import org.jjvm.instruction.dup.DUP_X1;
import org.jjvm.instruction.dup.DUP_X2;
import org.jjvm.instruction.inc.IINC;
import org.jjvm.instruction.load.ALOAD;
import org.jjvm.instruction.load.ALOAD_0;
import org.jjvm.instruction.load.ALOAD_1;
import org.jjvm.instruction.load.ALOAD_2;
import org.jjvm.instruction.load.ALOAD_3;
import org.jjvm.instruction.load.DLOAD;
import org.jjvm.instruction.load.DLOAD_0;
import org.jjvm.instruction.load.DLOAD_1;
import org.jjvm.instruction.load.DLOAD_2;
import org.jjvm.instruction.load.DLOAD_3;
import org.jjvm.instruction.load.FLOAD;
import org.jjvm.instruction.load.FLOAD_0;
import org.jjvm.instruction.load.FLOAD_1;
import org.jjvm.instruction.load.FLOAD_2;
import org.jjvm.instruction.load.FLOAD_3;
import org.jjvm.instruction.load.ILOAD;
import org.jjvm.instruction.load.ILOAD_1;
import org.jjvm.instruction.load.ILOAD_2;
import org.jjvm.instruction.load.ILOAD_3;
import org.jjvm.instruction.load.LLOAD;
import org.jjvm.instruction.load.LLOAD_0;
import org.jjvm.instruction.load.LLOAD_1;
import org.jjvm.instruction.load.LLOAD_2;
import org.jjvm.instruction.load.LLOAD_3;
import org.jjvm.instruction.mul.DMUL;
import org.jjvm.instruction.mul.FMUL;
import org.jjvm.instruction.mul.IMUL;
import org.jjvm.instruction.mul.LMUL;
import org.jjvm.instruction.neg.FNEG;
import org.jjvm.instruction.neg.INEG;
import org.jjvm.instruction.neg.LNEG;
import org.jjvm.instruction.or.IOR;
import org.jjvm.instruction.or.LOR;
import org.jjvm.instruction.pop.POP;
import org.jjvm.instruction.pop.POP2;
import org.jjvm.instruction.rem.DREM;
import org.jjvm.instruction.rem.FREM;
import org.jjvm.instruction.rem.IREM;
import org.jjvm.instruction.rem.LREM;
import org.jjvm.instruction.shift.ISHL;
import org.jjvm.instruction.shift.ISHR;
import org.jjvm.instruction.shift.IUSHR;
import org.jjvm.instruction.shift.LSHL;
import org.jjvm.instruction.shift.LSHR;
import org.jjvm.instruction.shift.LUSHR;
import org.jjvm.instruction.store.ASTORE;
import org.jjvm.instruction.store.ASTORE_0;
import org.jjvm.instruction.store.ASTORE_1;
import org.jjvm.instruction.store.ASTORE_2;
import org.jjvm.instruction.store.ASTORE_3;
import org.jjvm.instruction.store.DSTORE;
import org.jjvm.instruction.store.DSTORE_0;
import org.jjvm.instruction.store.DSTORE_1;
import org.jjvm.instruction.store.DSTORE_2;
import org.jjvm.instruction.store.DSTORE_3;
import org.jjvm.instruction.store.FSTORE;
import org.jjvm.instruction.store.FSTORE_0;
import org.jjvm.instruction.store.FSTORE_1;
import org.jjvm.instruction.store.FSTORE_2;
import org.jjvm.instruction.store.FSTORE_3;
import org.jjvm.instruction.store.ISTORE;
import org.jjvm.instruction.store.ISTORE_0;
import org.jjvm.instruction.store.ISTORE_1;
import org.jjvm.instruction.store.ISTORE_2;
import org.jjvm.instruction.store.ISTORE_3;
import org.jjvm.instruction.store.LSTORE;
import org.jjvm.instruction.store.LSTORE_0;
import org.jjvm.instruction.store.LSTORE_1;
import org.jjvm.instruction.store.LSTORE_2;
import org.jjvm.instruction.store.LSTORE_3;
import org.jjvm.instruction.sub.DSUB;
import org.jjvm.instruction.sub.FSUB;
import org.jjvm.instruction.sub.ISUB;
import org.jjvm.instruction.sub.LSUB;
import org.jjvm.instruction.swap.SWAP;
import org.jjvm.instruction.wide.GO_TO_W;
import org.jjvm.instruction.wide.WIDE;
import org.jjvm.instruction.xor.IXOR;
import org.jjvm.instruction.xor.LXOR;

public class Factory {
    static public Instruction createInstruction(int opcode) {
        switch (opcode) {
            case 0x00:
                return new NOP();
            case 0x01:
                return new ACONST_NULL();
            case 0x02:
                return new ICONST_M1();
            case 0x03:
                return new ICONST_0();
            case 0x04:
                return new ICONST_1();
            case 0x05:
                return new ICONST_2();
            case 0x06:
                return new ICONST_3();
            case 0x07:
                return new ICONST_4();
            case 0x08:
                return new ICONST_5();
            case 0x09:
                return new LCONST_0();
            case 0x0a:
                return new LCONST_1();
            case 0x0b:
                return new FCONST_0();
            case 0x0c:
                return new FCONST_1();
            case 0x0d:
                return new FCONST_2();
            case 0x0e:
                return new DCONST_0();
            case 0x0f:
                return new DCONST_1();
            case 0x10:
                return new BIPUSH();
            case 0x11:
                return new SIPUSH();
            // case 0x12:
            // 	return &LDC{}
            // case 0x13:
            // 	return &LDC_W{}
            // case 0x14:
            // 	return &LDC2_W{}
            case 0x15:
                return new ILOAD();
            case 0x16:
                return new LLOAD();
            case 0x17:
                return new FLOAD();
            case 0x18:
                return new DLOAD();
            case 0x19:
                return new ALOAD();
            case 0x1a:
                return new ILOAD();
            case 0x1b:
                return new ILOAD_1();
            case 0x1c:
                return new ILOAD_2();
            case 0x1d:
                return new ILOAD_3();
            case 0x1e:
                return new LLOAD_0();
            case 0x1f:
                return new LLOAD_1();
            case 0x20:
                return new LLOAD_2();
            case 0x21:
                return new LLOAD_3();
            case 0x22:
                return new FLOAD_0();
            case 0x23:
                return new FLOAD_1();
            case 0x24:
                return new FLOAD_2();
            case 0x25:
                return new FLOAD_3();
            case 0x26:
                return new DLOAD_0();
            case 0x27:
                return new DLOAD_1();
            case 0x28:
                return new DLOAD_2();
            case 0x29:
                return new DLOAD_3();
            case 0x2a:
                return new ALOAD_0();
            case 0x2b:
                return new ALOAD_1();
            case 0x2c:
                return new ALOAD_2();
            case 0x2d:
                return new ALOAD_3();
            // case 0x2e:
            // 	return iaload
            // case 0x2f:
            // 	return laload
            // case 0x30:
            // 	return faload
            // case 0x31:
            // 	return daload
            // case 0x32:
            // 	return aaload
            // case 0x33:
            // 	return baload
            // case 0x34:
            // 	return caload
            // case 0x35:
            // 	return saload
            case 0x36:
                return new ISTORE();
            case 0x37:
                return new LSTORE();
            case 0x38:
                return new FSTORE();
            case 0x39:
                return new DSTORE();
            case 0x3a:
                return new ASTORE();
            case 0x3b:
                return new ISTORE_0();
            case 0x3c:
                return new ISTORE_1();
            case 0x3d:
                return new ISTORE_2();
            case 0x3e:
                return new ISTORE_3();
            case 0x3f:
                return new LSTORE_0();
            case 0x40:
                return new LSTORE_1();
            case 0x41:
                return new LSTORE_2();
            case 0x42:
                return new LSTORE_3();
            case 0x43:
                return new FSTORE_0();
            case 0x44:
                return new FSTORE_1();
            case 0x45:
                return new FSTORE_2();
            case 0x46:
                return new FSTORE_3();
            case 0x47:
                return new DSTORE_0();
            case 0x48:
                return new DSTORE_1();
            case 0x49:
                return new DSTORE_2();
            case 0x4a:
                return new DSTORE_3();
            case 0x4b:
                return new ASTORE_0();
            case 0x4c:
                return new ASTORE_1();
            case 0x4d:
                return new ASTORE_2();
            case 0x4e:
                return new ASTORE_3();
            // case 0x4f:
            // 	return iastore
            // case 0x50:
            // 	return lastore
            // case 0x51:
            // 	return fastore
            // case 0x52:
            // 	return dastore
            // case 0x53:
            // 	return aastore
            // case 0x54:
            // 	return bastore
            // case 0x55:
            // 	return castore
            // case 0x56:
            // 	return sastore
            case 0x57:
                return new POP();
            case 0x58:
                return new POP2();
            case 0x59:
                return new DUP();
            case 0x5a:
                return new DUP_X1();
            case 0x5b:
                return new DUP_X2();
            case 0x5c:
                return new DUP2();
            case 0x5d:
                return new DUP2_X1();
            case 0x5e:
                return new DUP2_X2();
            case 0x5f:
                return new SWAP();
            case 0x60:
                return new IADD();
            case 0x61:
                return new LADD();
            case 0x62:
                return new FADD();
            case 0x63:
                return new DADD();
            case 0x64:
                return new ISUB();
            case 0x65:
                return new LSUB();
            case 0x66:
                return new FSUB();
            case 0x67:
                return new DSUB();
            case 0x68:
                return new IMUL();
            case 0x69:
                return new LMUL();
            case 0x6a:
                return new FMUL();
            case 0x6b:
                return new DMUL();
            case 0x6c:
                return new IDIV();
            case 0x6d:
                return new LDIV();
            case 0x6e:
                return new FDIV();
            case 0x6f:
                return new DDIV();
            case 0x70:
                return new IREM();
            case 0x71:
                return new LREM();
            case 0x72:
                return new FREM();
            case 0x73:
                return new DREM();
            case 0x74:
                return new INEG();
            case 0x75:
                return new LNEG();
            case 0x76:
                return new FNEG();
            case 0x77:
                return new FNEG();
            case 0x78:
                return new ISHL();
            case 0x79:
                return new LSHL();
            case 0x7a:
                return new ISHR();
            case 0x7b:
                return new LSHR();
            case 0x7c:
                return new IUSHR();
            case 0x7d:
                return new LUSHR();
            case 0x7e:
                return new IAND();
            case 0x7f:
                return new LAND();
            case 0x80:
                return new IOR();
            case 0x81:
                return new LOR();
            case 0x82:
                return new IXOR();
            case 0x83:
                return new LXOR();
            case 0x84:
                return new IINC();
            case 0x85:
                return new I2L();
            case 0x86:
                return new I2F();
            case 0x87:
                return new I2D();
            case 0x88:
                return new L2I();
            case 0x89:
                return new L2F();
            case 0x8a:
                return new L2D();
            case 0x8b:
                return new F2I();
            case 0x8c:
                return new F2L();
            case 0x8d:
                return new F2D();
            case 0x8e:
                return new D2I();
            case 0x8f:
                return new D2L();
            case 0x90:
                return new D2F();
            case 0x91:
                return new I2B();
            case 0x92:
                return new I2C();
            case 0x93:
                return new I2S();
            case 0x94:
                return new LCMP();
            case 0x95:
                return new FCMPL();
            case 0x96:
                return new FCMPG();
            case 0x97:
                return new DCMPL();
            case 0x98:
                return new DCMPG();
            case 0x99:
                return new IF_EQ();
            case 0x9a:
                return new IF_NE();
            case 0x9b:
                return new IF_LT();
            case 0x9c:
                return new IF_GE();
            case 0x9d:
                return new IF_GT();
            case 0x9e:
                return new IF_LE();
            case 0x9f:
                return new IF_ICMPEQ();
            case 0xa0:
                return new IF_ICMPNE();
            case 0xa1:
                return new IF_ICMPLT();
            case 0xa2:
                return new IF_ICMPGE();
            case 0xa3:
                return new IF_ICMPGT();
            case 0xa4:
                return new IF_ICMPLE();
            case 0xa5:
                return new IF_ACMPEQ();
            case 0xa6:
                return new IF_ACMPNE();
            case 0xa7:
                return new GO_TO();
            // case 0xa8:
            // 	return &JSR{}
            // case 0xa9:
            // 	return &RET{}
            case 0xaa:
                return new TABLE_SWITCH();
            case 0xab:
                return new LOOKUP_SWITCH();
            // case 0xac:
            // 	return ireturn
            // case 0xad:
            // 	return lreturn
            // case 0xae:
            // 	return freturn
            // case 0xaf:
            // 	return dreturn
            // case 0xb0:
            // 	return areturn
            // case 0xb1:
            // 	return _return
            //	case 0xb2:
            //		return &GET_STATIC{}
            // case 0xb3:
            // 	return &PUT_STATIC{}
            // case 0xb4:
            // 	return &GET_FIELD{}
            // case 0xb5:
            // 	return &PUT_FIELD{}
            //	case 0xb6:
            //		return &INVOKE_VIRTUAL{}
            // case 0xb7:
            // 	return &INVOKE_SPECIAL{}
            // case 0xb8:
            // 	return &INVOKE_STATIC{}
            // case 0xb9:
            // 	return &INVOKE_INTERFACE{}
            // case 0xba:
            // 	return &INVOKE_DYNAMIC{}
            // case 0xbb:
            // 	return &NEW{}
            // case 0xbc:
            // 	return &NEW_ARRAY{}
            // case 0xbd:
            // 	return &ANEW_ARRAY{}
            // case 0xbe:
            // 	return arraylength
            // case 0xbf:
            // 	return athrow
            // case 0xc0:
            // 	return &CHECK_CAST{}
            // case 0xc1:
            // 	return &INSTANCE_OF{}
            // case 0xc2:
            // 	return monitorenter
            // case 0xc3:
            // 	return monitorexit
            case 0xc4:
                return new WIDE();
            // case 0xc5:
            // 	return &MULTI_ANEW_ARRAY{}
            case 0xc6:
                return new IF_NULL();
            case 0xc7:
                return new IF_NONNULL();
            case 0xc8:
                return new GO_TO_W();
            // case 0xc9:
            // 	return &JSR_W{}
            // case 0xca: breakpoint
            // case 0xfe: impdep1
            // case 0xff: impdep2
            default:
                JJException.throwException("Unsupported opcode: 0x" + Integer.toHexString(opcode));
            }
            return null;
    } 

}
