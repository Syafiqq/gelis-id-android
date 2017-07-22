package app.helmi.gelis;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 22 July 2017, 1:27 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

class Banner
{
    public String id;
    public String tanggal_dibuat;
    public String tanggal_berakhir;
    public String fitur_promosi;
    public String foto;
    public String is_show;
    public String action;

    public Banner()
    {
    }

    public Banner(String id, String tanggal_dibuat, String tanggal_berakhir, String fitur_promosi, String foto, String is_show, String action)
    {
        this.id = id;
        this.tanggal_dibuat = tanggal_dibuat;
        this.tanggal_berakhir = tanggal_berakhir;
        this.fitur_promosi = fitur_promosi;
        this.foto = foto;
        this.is_show = is_show;
        this.action = action;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTanggal_dibuat()
    {
        return this.tanggal_dibuat;
    }

    public void setTanggal_dibuat(String tanggal_dibuat)
    {
        this.tanggal_dibuat = tanggal_dibuat;
    }

    public String getTanggal_berakhir()
    {
        return this.tanggal_berakhir;
    }

    public void setTanggal_berakhir(String tanggal_berakhir)
    {
        this.tanggal_berakhir = tanggal_berakhir;
    }

    public String getFitur_promosi()
    {
        return this.fitur_promosi;
    }

    public void setFitur_promosi(String fitur_promosi)
    {
        this.fitur_promosi = fitur_promosi;
    }

    public String getFoto()
    {
        return this.foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public String getIs_show()
    {
        return this.is_show;
    }

    public void setIs_show(String is_show)
    {
        this.is_show = is_show;
    }

    public String getAction()
    {
        return this.action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("Banner{");
        sb.append("id='").append(id).append('\'');
        sb.append(", tanggal_dibuat='").append(tanggal_dibuat).append('\'');
        sb.append(", tanggal_berakhir='").append(tanggal_berakhir).append('\'');
        sb.append(", fitur_promosi='").append(fitur_promosi).append('\'');
        sb.append(", foto='").append(foto).append('\'');
        sb.append(", is_show='").append(is_show).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
