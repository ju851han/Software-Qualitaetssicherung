/**
 * Aufgabe 3
 */
public final class StackMapEntry {
    private int frame_type;
    private int byte_code_offset;
    private String[] types_of_locals;
    private String[] types_of_stack_items;

    public StackMapEntry(int frame_type,
                         int byte_code_offset,
                         String[] types_of_locals,
                         String[] types_of_stack_items) {
        this.frame_type = frame_type;
        this.byte_code_offset = byte_code_offset;
        this.types_of_locals = types_of_locals;
        this.types_of_stack_items = types_of_stack_items;
    }

    public final String toString() {
        final StringBuilder buf = new StringBuilder(64);
        buf.append("(");
        buf.append("ft=").append(frame_type);
        buf.append(", off=").append(byte_code_offset);
        if (types_of_locals.length > 0) {
            buf.append(", locals={");
            for (int i = 0; i < types_of_locals.length; i++) {
                buf.append(types_of_locals[i]);
                if (i < types_of_locals.length - 1) {
                    buf.append(", ");
                }
            }
            buf.append("}");
        }
        if (types_of_stack_items.length > 0) {
            buf.append(", items={");
            for (int i = 0; i < types_of_stack_items.length;
                 i++) {
                buf.append(types_of_stack_items[i]);
                if (i < types_of_stack_items.length - 1) {
                    buf.append(", ");
                }
            }
            buf.append("}");
        }
        buf.append(")");
        return buf.toString();
    }
}
