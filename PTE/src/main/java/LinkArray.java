import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Date;

public class LinkArray implements Metodozzi {

    private String url;
    private final Date data;

    public LinkArray(String url, Date data) {
        this.url = url;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public Date getData() {
        return data;
    }

    public void Time() {
        Date data = new Date(System.currentTimeMillis());
    }

    ArrayList Links = new ArrayList();

    @Override
    public void Popolatore() {
        for(int i =0; i < Links.size(); i++) {
            Links.add();
        }
    }

    public int MinCharString() {
        int min = 0;
        for(int i = 0; i < Links.size(); i++) {
            if(Links.get(i).toString().length() < min) {
                min = Links.get(i).toString().length();
            }
        }
        return min;
    }

    public void Ordinamento() {
        LinkArray temp = new LinkArray(null, null);
        for(int i = Links.size() - 1; i > 0; i--) {
            for(int j = i + 1; j >= 0; j--) {
                for(int k = 0; k < MinCharString(); k++) {
                    if(((String) Links.get(j)).charAt(k) > ((String) Links.get(j)).charAt(k)) {
                        temp = (LinkArray) Links.get(j);
                        Links.set(j, Links.get(i));
                        Links.set(j, temp);
                        break;
                    }
                }
            }
        }
    }

}
