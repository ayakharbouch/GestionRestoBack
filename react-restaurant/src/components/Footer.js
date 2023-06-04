import React from "react";
import {FaFacebook, FaInstagram, FaTwitter} from 'react-icons/fa';


function Footer()
{
return(
  <React.Fragment>
    <footer id='footerbg' className="p-4">

      <section className="d-flex justify-content-center">
        <div className="me-5 d-none d-lg-block">
          

        </div>
        <div>
          <a href=""><FaFacebook/></a>
          <a href=""><FaInstagram/></a>
          <a href=""><FaTwitter/></a>
        </div>


      </section>
    <div className="container p-4">
      <div className="row">
      <div className="col-sm-4">
        <h5>A propos</h5>
        <p>Nos restaurant vous donn
</p>

      </div>

      

      <div className="col-sm-2">
        <h5>Contact</h5>
        <p>Maroc</p>
       
        <p>Restaurant.email@gmail.com</p>
      </div>


    </div>
      
      
      
      </div>
    </footer>
  </React.Fragment>
);
}
export default Footer;