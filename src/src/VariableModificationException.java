
/**
 * @author 千年
 * @version 1.0.0
 * @since 2021-5-30
 */
public class VariableModificationException extends Exception
{
    public VariableModificationException()
    {
        super();
    }

    public VariableModificationException(final String message)
    {
        super(message);
    }

    public VariableModificationException(final String message, final Throwable cause)
    {
        super(message, cause);
    }
}
