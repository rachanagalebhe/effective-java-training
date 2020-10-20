
class FurnitureApp{

    public static void main(String []args){

        furnitures.livingroom.Chair chair1=new furnitures.livingroom.Chair();  //Living room chair

        furnitures.livingroom.Table table1=new furnitures.livingroom.Table();

        furnitures.bedroom.Bed bed=new furnitures.bedroom.Bed();       //Bedroom Bed

        data.Table table=new data.Table(); //living room table
                
        data.List list=new data.List();

        furnitures.office.Chair chair2=new furnitures.office.Chair();  //Living room chair

        furnitures.office.Table table2=new furnitures.office.Table();

        System.out.printf("The price of %s is %d\n",chair1, chair1.price());
        System.out.printf("The price of %s is %d\n",table1, table1.price());

        System.out.printf("The price of %s is %d\n",bed, bed.price());
        System.out.printf("The price of %s is %d\n",table2, table2.price());
        System.out.printf("The price of %s is %d\n",chair2, chair2.price());

    
        System.out.println("list is"+list);
        System.out.println("table list is"+table);
    }
}