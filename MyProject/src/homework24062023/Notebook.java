package homework24062023;

class Notebook {
    private String brand;
    private String model;
    private int price;
    private int ramSize;
    private int hardDiskSize;
    private String gpuBrand;

    public Notebook(String brand, String model, int price, int ramSize, int hardDiskSize, String gpuBrand) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ramSize = ramSize;
        this.hardDiskSize = hardDiskSize;
        this.gpuBrand = gpuBrand;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getHardDiskSize() {
        return hardDiskSize;
    }

    public String getGpuBrand() {
        return gpuBrand;
    }

    /**
     * проверка равенства с другим экземпляром
     * класса Notebook
     */
    @Override
    public boolean equals(Object notebook) {
        boolean res = false;
        if (notebook instanceof Notebook note) {
            var a = this.brand.equals(note.getBrand());
            var b = this.model.equals(note.getModel());
            var c = this.price == note.getPrice();
            var d = this.ramSize == note.getRamSize();
            var e = this.hardDiskSize == note.getHardDiskSize();
            var f = this.gpuBrand.equals(note.getGpuBrand());
            res = a && b && c && d && e && f;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", ramSize=" + ramSize +
                ", hardDiskSize=" + hardDiskSize +
                ", gpuBrand='" + gpuBrand + '\'' +
                '}';
    }
}
