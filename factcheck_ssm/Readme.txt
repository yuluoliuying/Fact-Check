Javaweb后端选用了SSM框架
1.配置Mybatis层：Sprint_root.xml，Sprint_web，以及dao映射factMapper.xml,以及FactDao.java,用sql语句从用Tomcat连接的mysql数据库中提取相应数据
2.entity层：根据所要的数据编写实体，目前设计的是谣言ID,name，以及content。
3.service层：在此进行业务判断，这里是返回了数据库中所有谣言信息。
4.web层：controller进行业务处理后返回一共ModelAndView对象，这里的ModelAndView对象是加入了所有谣言信息的表单