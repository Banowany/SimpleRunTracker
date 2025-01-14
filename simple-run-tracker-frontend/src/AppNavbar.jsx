// src/components/Navbar.jsx
import React from 'react';
import {Nav, Navbar, NavLink} from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import {useNavigate} from "react-router-dom";


const AppNavbar = () => {
    // return (
    //     <Navbar bg="light" expand="lg">
    //         <Navbar.Brand href="/">Training App</Navbar.Brand>
    //         <Navbar.Toggle aria-controls="basic-navbar-nav" />
    //         <Navbar.Collapse id="basic-navbar-nav">
    //             <Nav className="mr-auto">
    //                 <LinkContainer to="/calendar">
    //                     <Nav.Link>Calendar</Nav.Link>
    //                 </LinkContainer>
    //                 <LinkContainer to="/summary">
    //                     <Nav.Link>Summary</Nav.Link>
    //                 </LinkContainer>
    //             </Nav>
    //         </Navbar.Collapse>
    //     </Navbar>
    // );

    let navigate = useNavigate();

    const onBrandClick = () => {
        navigate("/");
    }

    const onCalendarClick = () => {
        navigate("/calendar");
    }

    const onSummaryClick = () => {
        navigate("/summary");
    }

    return (
        <Navbar>
            <Navbar.Brand
                onClick={onBrandClick}
                style={{cursor: "pointer"}}
            >
                Training App
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link onClick={onCalendarClick}>
                        Calendar
                    </Nav.Link>
                    <Nav.Link onClick={onSummaryClick}>
                        Summary
                    </Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    )
};

export default AppNavbar;