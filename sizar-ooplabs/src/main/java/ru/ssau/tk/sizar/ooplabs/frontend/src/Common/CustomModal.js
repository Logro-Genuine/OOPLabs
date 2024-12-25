import React from 'react';
import { Modal, Button } from 'react-bootstrap';

const CustomModal = ({ show, onHide, title, body, confirmText, confirmAction, secondButtonText, secondButtonAction, variant }) => {
    return (
        <Modal show={show} onHide={onHide}>
            <Modal.Header closeButton>
                <Modal.Title>{title}</Modal.Title>
            </Modal.Header>
            <Modal.Body>{body}</Modal.Body>
            <Modal.Footer>
                {secondButtonText && (
                    <Button variant="secondary" onClick={secondButtonAction}>
                        {secondButtonText}
                    </Button>
                )}
                <Button variant={variant} onClick={confirmAction}>
                    {confirmText}
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default CustomModal;
