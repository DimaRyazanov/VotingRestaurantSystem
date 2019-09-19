delete from restaurants;
alter table restaurants alter column id restart with 1;

insert into restaurants(name) values
('Ресторан на тверской'),
('Gudini'),
('Das is good'),
('На парах');