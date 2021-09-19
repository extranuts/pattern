package structural.adapter;

public class AdapterRunner {

    public static void main(String[] args) {
        //1 example inheritance
        var vectorAdapterFromRaster = new VectorAdapterFromRaster();
        vectorAdapterFromRaster.drawLine();
        vectorAdapterFromRaster.drawRasterSquare();

        //2 example composition
        var vectorAdapterFromRaster2 = new VectorAdapterFromRaster2(new RasterGraphics());
        vectorAdapterFromRaster2.drawSquare();
        vectorAdapterFromRaster2.drawLine();
    }
}

interface VectorGraphicsInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster
        extends RasterGraphics
        implements VectorGraphicsInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2
        implements VectorGraphicsInterface {

    RasterGraphics rasterGraphics = null;//new RasterGraphics();

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics){
        this.rasterGraphics =rasterGraphics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}