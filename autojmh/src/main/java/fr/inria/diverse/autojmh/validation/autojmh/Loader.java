
package fr.inria.diverse.autojmh.validation.autojmh;

import java.io.*;
import java.util.*;

public class Loader {
    /**
     * Given a id, provides a stream
     */
    public static class InputStreamProvider {
        /**
         * Returns a data stream
         * @param path
         * @param dataFile
         * @return
         */
        public DataInputStream getStream(String path, final String dataFile) {
            try {
                File f = new File(path + "/" + dataFile);
                return new DataInputStream(new BufferedInputStream(
                        new FileInputStream(f), 1024));
            } catch (IOException e) {
                //Don't handle much, if something goes wrong is not this loop's fault
                throw new RuntimeException(e);
            }
        }
    }



    public ArrayList< Byte > readByteArrayList() {
        ArrayList< Byte > result = new ArrayList< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Byte > readByteLinkedList() {
        LinkedList< Byte > result = new LinkedList< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public List< Byte > readByteList() {
        List< Byte > result = new ArrayList< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public HashSet< Byte > readByteHashSet() {
        HashSet< Byte > result = new HashSet< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public Set< Byte > readByteSet() {
        Set< Byte > result = new HashSet< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Byte > readByteSortedSet() {
        SortedSet< Byte > result = new TreeSet< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public Collection< Byte > readByteCollection() {
        Collection< Byte > result = new ArrayList< Byte >();
        byte[] nn = readArray1byte();
        for ( byte v : nn ) result.add(v);
        return result;
    }


    public byte[] readArray1byte() {
        try {
            int length = openStream.readInt();
            byte[] result = new byte[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readByte();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[][][] readArray3byte() {
        try {
            int length = openStream.readInt();
            byte[][][] result = new byte[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new byte[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new byte[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readByte();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[][] readArray2byte() {
        try {
            int length = openStream.readInt();
            byte[][] result = new byte[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new byte[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readByte();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte readbyte() {
        try {
            return openStream.readByte();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< Short > readShortArrayList() {
        ArrayList< Short > result = new ArrayList< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Short > readShortLinkedList() {
        LinkedList< Short > result = new LinkedList< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public List< Short > readShortList() {
        List< Short > result = new ArrayList< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public HashSet< Short > readShortHashSet() {
        HashSet< Short > result = new HashSet< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public Set< Short > readShortSet() {
        Set< Short > result = new HashSet< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Short > readShortSortedSet() {
        SortedSet< Short > result = new TreeSet< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public Collection< Short > readShortCollection() {
        Collection< Short > result = new ArrayList< Short >();
        short[] nn = readArray1short();
        for ( short v : nn ) result.add(v);
        return result;
    }


    public short[] readArray1short() {
        try {
            int length = openStream.readInt();
            short[] result = new short[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readShort();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public short[][][] readArray3short() {
        try {
            int length = openStream.readInt();
            short[][][] result = new short[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new short[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new short[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readShort();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public short[][] readArray2short() {
        try {
            int length = openStream.readInt();
            short[][] result = new short[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new short[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readShort();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public short readshort() {
        try {
            return openStream.readShort();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< Integer > readIntegerArrayList() {
        ArrayList< Integer > result = new ArrayList< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Integer > readIntegerLinkedList() {
        LinkedList< Integer > result = new LinkedList< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public List< Integer > readIntegerList() {
        List< Integer > result = new ArrayList< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public HashSet< Integer > readIntegerHashSet() {
        HashSet< Integer > result = new HashSet< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public Set< Integer > readIntegerSet() {
        Set< Integer > result = new HashSet< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Integer > readIntegerSortedSet() {
        SortedSet< Integer > result = new TreeSet< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public Collection< Integer > readIntegerCollection() {
        Collection< Integer > result = new ArrayList< Integer >();
        int[] nn = readArray1int();
        for ( int v : nn ) result.add(v);
        return result;
    }


    public int[] readArray1int() {
        try {
            int length = openStream.readInt();
            int[] result = new int[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readInt();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int[][][] readArray3int() {
        try {
            int length = openStream.readInt();
            int[][][] result = new int[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new int[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new int[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readInt();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int[][] readArray2int() {
        try {
            int length = openStream.readInt();
            int[][] result = new int[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new int[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readInt();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int readint() {
        try {
            return openStream.readInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< Long > readLongArrayList() {
        ArrayList< Long > result = new ArrayList< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Long > readLongLinkedList() {
        LinkedList< Long > result = new LinkedList< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public List< Long > readLongList() {
        List< Long > result = new ArrayList< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public HashSet< Long > readLongHashSet() {
        HashSet< Long > result = new HashSet< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public Set< Long > readLongSet() {
        Set< Long > result = new HashSet< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Long > readLongSortedSet() {
        SortedSet< Long > result = new TreeSet< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public Collection< Long > readLongCollection() {
        Collection< Long > result = new ArrayList< Long >();
        long[] nn = readArray1long();
        for ( long v : nn ) result.add(v);
        return result;
    }


    public long[] readArray1long() {
        try {
            int length = openStream.readInt();
            long[] result = new long[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readLong();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long[][][] readArray3long() {
        try {
            int length = openStream.readInt();
            long[][][] result = new long[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new long[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new long[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readLong();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long[][] readArray2long() {
        try {
            int length = openStream.readInt();
            long[][] result = new long[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new long[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readLong();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long readlong() {
        try {
            return openStream.readLong();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< Float > readFloatArrayList() {
        ArrayList< Float > result = new ArrayList< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Float > readFloatLinkedList() {
        LinkedList< Float > result = new LinkedList< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public List< Float > readFloatList() {
        List< Float > result = new ArrayList< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public HashSet< Float > readFloatHashSet() {
        HashSet< Float > result = new HashSet< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public Set< Float > readFloatSet() {
        Set< Float > result = new HashSet< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Float > readFloatSortedSet() {
        SortedSet< Float > result = new TreeSet< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public Collection< Float > readFloatCollection() {
        Collection< Float > result = new ArrayList< Float >();
        float[] nn = readArray1float();
        for ( float v : nn ) result.add(v);
        return result;
    }


    public float[] readArray1float() {
        try {
            int length = openStream.readInt();
            float[] result = new float[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readFloat();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public float[][][] readArray3float() {
        try {
            int length = openStream.readInt();
            float[][][] result = new float[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new float[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new float[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readFloat();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public float[][] readArray2float() {
        try {
            int length = openStream.readInt();
            float[][] result = new float[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new float[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readFloat();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public float readfloat() {
        try {
            return openStream.readFloat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< Double > readDoubleArrayList() {
        ArrayList< Double > result = new ArrayList< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Double > readDoubleLinkedList() {
        LinkedList< Double > result = new LinkedList< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public List< Double > readDoubleList() {
        List< Double > result = new ArrayList< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public HashSet< Double > readDoubleHashSet() {
        HashSet< Double > result = new HashSet< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public Set< Double > readDoubleSet() {
        Set< Double > result = new HashSet< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Double > readDoubleSortedSet() {
        SortedSet< Double > result = new TreeSet< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public Collection< Double > readDoubleCollection() {
        Collection< Double > result = new ArrayList< Double >();
        double[] nn = readArray1double();
        for ( double v : nn ) result.add(v);
        return result;
    }


    public double[] readArray1double() {
        try {
            int length = openStream.readInt();
            double[] result = new double[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readDouble();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double[][][] readArray3double() {
        try {
            int length = openStream.readInt();
            double[][][] result = new double[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new double[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new double[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readDouble();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double[][] readArray2double() {
        try {
            int length = openStream.readInt();
            double[][] result = new double[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new double[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readDouble();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double readdouble() {
        try {
            return openStream.readDouble();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public char[] readArray1char() {
        try {
            int length = openStream.readInt();
            char[] result = new char[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readChar();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public char[][][] readArray3char() {
        try {
            int length = openStream.readInt();
            char[][][] result = new char[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new char[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new char[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readChar();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public char[][] readArray2char() {
        try {
            int length = openStream.readInt();
            char[][] result = new char[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new char[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readChar();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public char readchar() {
        try {
            return openStream.readChar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< String > readStringArrayList() {
        ArrayList< String > result = new ArrayList< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public LinkedList< String > readStringLinkedList() {
        LinkedList< String > result = new LinkedList< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public List< String > readStringList() {
        List< String > result = new ArrayList< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public HashSet< String > readStringHashSet() {
        HashSet< String > result = new HashSet< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public Set< String > readStringSet() {
        Set< String > result = new HashSet< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public SortedSet< String > readStringSortedSet() {
        SortedSet< String > result = new TreeSet< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public Collection< String > readStringCollection() {
        Collection< String > result = new ArrayList< String >();
        String[] nn = readArray1String();
        for ( String v : nn ) result.add(v);
        return result;
    }


    public String[] readArray1String() {
        try {
            int length = openStream.readInt();
            String[] result = new String[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readUTF();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String[][][] readArray3String() {
        try {
            int length = openStream.readInt();
            String[][][] result = new String[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new String[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new String[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readUTF();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String[][] readArray2String() {
        try {
            int length = openStream.readInt();
            String[][] result = new String[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new String[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readUTF();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String readString() {
        try {
            return openStream.readUTF();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList< Boolean > readBooleanArrayList() {
        ArrayList< Boolean > result = new ArrayList< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public LinkedList< Boolean > readBooleanLinkedList() {
        LinkedList< Boolean > result = new LinkedList< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public List< Boolean > readBooleanList() {
        List< Boolean > result = new ArrayList< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public HashSet< Boolean > readBooleanHashSet() {
        HashSet< Boolean > result = new HashSet< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public Set< Boolean > readBooleanSet() {
        Set< Boolean > result = new HashSet< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public SortedSet< Boolean > readBooleanSortedSet() {
        SortedSet< Boolean > result = new TreeSet< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public Collection< Boolean > readBooleanCollection() {
        Collection< Boolean > result = new ArrayList< Boolean >();
        boolean[] nn = readArray1boolean();
        for ( boolean v : nn ) result.add(v);
        return result;
    }


    public boolean[] readArray1boolean() {
        try {
            int length = openStream.readInt();
            boolean[] result = new boolean[length];
            for (int k = 0; k < length; k++) result[k] = openStream.readBoolean();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean[][][] readArray3boolean() {
        try {
            int length = openStream.readInt();
            boolean[][][] result = new boolean[length][][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new boolean[kSize][];
                for (int i = 0; i < kSize; i++) {
                    int iSize = openStream.readInt();
                    result[k][i] = new boolean[iSize];
                    for (int j = 0; j < iSize; j++)
                        result[k][i][j] = openStream.readBoolean();
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean[][] readArray2boolean() {
        try {
            int length = openStream.readInt();
            boolean[][] result = new boolean[length][];
            for (int k = 0; k < length; k++) {
                int kSize = openStream.readInt();
                result[k] = new boolean[kSize];
                for (int i = 0; i < kSize; i++)
                    result[k][i] = openStream.readBoolean();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean readboolean() {
        try {
            return openStream.readBoolean();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public <T> T readSerializable() {
        try {
            ObjectInputStream ois = new ObjectInputStream(openStream);
            return (T)ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public <T> ArrayList< T > readSerializableArrayList() {

        try {
            ArrayList< T > result = new ArrayList< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> LinkedList< T > readSerializableLinkedList() {

        try {
            LinkedList< T > result = new LinkedList< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> List< T > readSerializableList() {

        try {
            List< T > result = new ArrayList< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> HashSet< T > readSerializableHashSet() {

        try {
            HashSet< T > result = new HashSet< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> Set< T > readSerializableSet() {

        try {
            Set< T > result = new HashSet< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> SortedSet< T > readSerializableSortedSet() {

        try {
            SortedSet< T > result = new TreeSet< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> Collection< T > readSerializableCollection() {

        try {
            Collection< T > result = new ArrayList< T >();
            T[] nn = readArray1Serializable();
            for ( T v : nn ) result.add(v);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> T[] readArray1Serializable() {
        try {
            int length = openStream.readInt();
            Object[] result = new Object[length];
            for (int k = 0; k < length; k++) {
                ObjectInputStream ois = new ObjectInputStream(openStream);
                result[k] = ois.readObject();
            }
            return (T[])result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stream from which all data will be read
     */
    private DataInputStream openStream;

    /**
     * Input stream provider
     */
    private InputStreamProvider provider;

    public void setStreamProvider(InputStreamProvider provider) {
        this.provider = provider;
    }

    public InputStreamProvider getStreamProvider() {
        if ( provider == null ) provider = new InputStreamProvider();
        return provider;
    }

    /**
     * Returns a data stream
     * @param path Path to where all the files are now
     * @param dataFile Name of the single file representing this case
     * @return A stream to that file
     */
    public void openStream(String path, final String dataFile) {
        openStream = getStreamProvider().getStream(path, dataFile);
    }

    public void closeStream() {
        try {
            openStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertDoubleArrayEquals(double[] data, double[] data1) {

    }
}

