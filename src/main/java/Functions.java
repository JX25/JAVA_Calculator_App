public class Functions {
    private String menuKey;
    private String parser;

    public Functions(String first, String second)
    {
        menuKey = first;
        parser = second;
    }

    public String getMenuKey()
    {
        return menuKey;
    }

    public void setMenuKey(String key)
    {
        menuKey = key;
    }

    public String getParser()
    {
        return parser;
    }

    public void setParser(String pars)
    {
        parser = pars;
    }

    @Override
    public String toString() {
        return menuKey;
    }

}
