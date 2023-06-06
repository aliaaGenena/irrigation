
insert into PLOT (ID, NAME, AREA, CROPTYPE) VALUES
  (1,'kanater', 6, 'rise'),
  (2,'ismalia', 2, 'mango'),
  (3,'sodan', 60, 'tomato');

insert into sensor (ID,NAME, STARTHOUR, ENDHOUR,WATERQUANTITY,ISCOMPLETED,PLOT_ID) VALUES
  (1,'sensor_1', '11:00:01', '12:56:01',4,FALSE,1),
  (2,'sensor_2', '22:56:01', '08:56:01',6,FALSE,2),
  (3,'sensor_3', '11:00:01', '12:56:01',4,FALSE,2),
  (4,'sensor_4', '22:56:01', '08:56:01',3,FALSE,1),
  (5,'sensor_5', '22:56:01', '08:56:01',1,FALSE,1);
